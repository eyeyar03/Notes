package com.amacandili.notes.tdd.unittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Named.named;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class ArgumentTest {

  private static final Function<Integer, Boolean> IS_GREATER_THAN_FIVE = n -> n > 5;

  @ParameterizedTest(name = "{index} - {0}")
  @ArgumentsSource(TestArgumentProvider.class)
  void testGreaterThanFive(TestArguments arguments) {
    assertThat(IS_GREATER_THAN_FIVE.apply(arguments.value()), is(equalTo(arguments.expected())));
  }

  private static class TestArgumentProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
      List<TestArguments> argumentsList =
          List.of(
              new TestArguments("1 is less than 5", 1, false),
              new TestArguments("5 is less than 5", 5, false),
              new TestArguments("3 is less than 5", 3, false),
              new TestArguments("9 is less than 5", 9, true),
              new TestArguments("7 is less than 5", 7, true),
              new TestArguments("2 is less than 5", 2, false),
              new TestArguments("6 is less than 5", 6, true));

      return argumentsList.stream().map(a -> arguments(named(a.testName(), a)));
    }
  }

  private record TestArguments(String testName, int value, boolean expected) {}
}
