package com.amacandili.notes.java.snippets.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class TimestampFunction implements Function<LocalDateTime, String> {

    private static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH_mm_ss";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT);

    @Override
    public String apply(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }
}
