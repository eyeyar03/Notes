package com.amacandili.notes.java.snippets.concurrency;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.time.Duration;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class CompletableFutureTest {

  private final PriceService priceService = new PriceService();

  @Test
  void getTotalWithoutUsingCompletableFuture() {
    var before = Instant.now();

    int total = priceService.getTotal();

    long elapsedTimeInSeconds = Duration.between(before, Instant.now()).toSeconds();
    System.out.printf("Elapsed time: %s seconds.", elapsedTimeInSeconds);

    assertThat(total, is(equalTo(3270)));
    assertThat(elapsedTimeInSeconds, is(greaterThanOrEqualTo(9L)));
  }

  @Test
  void getTotalUsingCompletableFuture() {
    var before = Instant.now();

    int total = priceService.getTotalAsync();

    long elapsedTimeInSeconds = Duration.between(before, Instant.now()).toSeconds();
    System.out.printf("Elapsed time: %s seconds.", elapsedTimeInSeconds);

    assertThat(total, is(equalTo(3270)));
    assertThat(elapsedTimeInSeconds, is(lessThanOrEqualTo(1L)));
  }
}
