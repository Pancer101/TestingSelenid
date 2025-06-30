package com.utils;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class TimeoutDuration {

    public static final Duration TIMEOUT_LONG = ofSeconds(15);
    public static final Duration TIMEOUT_MIDDLE = ofSeconds(10);
    public static final Duration TIMEOUT_LOW = ofSeconds(5);
}
