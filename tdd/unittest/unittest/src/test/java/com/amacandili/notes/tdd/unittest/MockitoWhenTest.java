package com.amacandili.notes.tdd.unittest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Supplier;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MockitoWhenTest {

  @Test
  void shouldReturnConcatenatedStringFromBufferedReader() throws Exception {
    BufferedReader bufferedReaderMock = Mockito.mock(BufferedReader.class);

    Mockito.when(bufferedReaderMock.readLine())
        .thenReturn("Hello ")
        .thenReturn("World!")
        .thenReturn(" This ")
        .thenReturn("string ")
        .thenReturn("is")
        .thenReturn(" from ")
        .thenReturn("BufferedReader!")
        .thenReturn(null);

    Supplier<String> greetingsSupplier = new GreetingsSupplier(bufferedReaderMock);

    assertThat(
        greetingsSupplier.get(), is(equalTo("Hello World! This string is from BufferedReader!")));
  }

  private record GreetingsSupplier(BufferedReader bufferedReader) implements Supplier<String> {

    @Override
    public String get() {
      StringBuilder sb = new StringBuilder();
      try {
        String line;
        while (Objects.nonNull(line = bufferedReader.readLine())) {
          sb.append(line);
        }

      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      return sb.toString();
    }
  }
}
