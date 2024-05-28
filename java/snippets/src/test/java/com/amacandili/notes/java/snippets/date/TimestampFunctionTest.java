package com.amacandili.notes.java.snippets.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class TimestampFunctionTest {

    @Test
    void shouldReturnTimestamp() {
        Function<LocalDateTime, String> timestampFunction = new TimestampFunction();

        String timeStamp = timestampFunction.apply(LocalDateTime.of(LocalDate.of(2024, Month.MAY, 28), LocalTime.of(16, 30, 55)));

        assertThat(timeStamp, is(equalTo("2024-05-28T16_30_55")));
    }
}
