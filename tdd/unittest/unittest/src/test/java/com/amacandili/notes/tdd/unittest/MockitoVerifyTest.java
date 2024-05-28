package com.amacandili.notes.tdd.unittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockitoVerifyTest {

  private static final String QUERY =
      "SELECT id, first_name, last_name, age FROM some.database.hero_table WHERE shift = 'MIDNIGHT'; ";

  @Test
  void testWithoutUsingVerify() {
    Function<String, Object[]> selectCommand = new SelectCommand();

    DatabaseProxy databaseProxy = new DatabaseProxy(selectCommand);

    // this result set is a "real" data from database.
    Object[] resultSet = databaseProxy.executeQuery(QUERY);

    assertThat(resultSet[0], is(equalTo(1)));
    assertThat(resultSet[1], is(equalTo("Thomas")));
    assertThat(resultSet[2], is(equalTo("Wayne")));
    assertThat(resultSet[3], is(equalTo(40)));
  }

  @Test
  void testUsingVerify() {
    Function<String, Object[]> mockedSelectCommand = Mockito.mock(Function.class);
    Mockito.when(mockedSelectCommand.apply(QUERY))
        .thenReturn(new Object[] {2, "Peter", "Parker", 30});

    DatabaseProxy databaseProxy = new DatabaseProxy(mockedSelectCommand);

    // this result set is mocked.
    Object[] resultSet = databaseProxy.executeQuery(QUERY);

    Mockito.verify(mockedSelectCommand, Mockito.times(1)).apply(QUERY);

    assertThat(resultSet[0], is(equalTo(2)));
    assertThat(resultSet[1], is(equalTo("Peter")));
    assertThat(resultSet[2], is(equalTo("Parker")));
    assertThat(resultSet[3], is(equalTo(30)));
  }

  private record DatabaseProxy(Function<String, Object[]> queryCommand) {

    Object[] executeQuery(String query) {
      return queryCommand.apply(query);
    }
  }

  private static class SelectCommand implements Function<String, Object[]> {

    @Override
    public Object[] apply(String query) {
      // this will only be printed out when SelectCommand is not mocked.
      System.out.println("Executing query: " + query);

      Object[] resultSet = {1, "Thomas", "Wayne", 40}; // some result set

      return resultSet;
    }
  }
}
