package com.cinemax.domain.values;

import java.time.LocalDateTime;
import java.util.Objects;

public class Time {

    private static final int MIN_HOUR = 0;
    private static final int MAX_HOUR = 24;

    private static final int MIN_MINUTE = 0;
    private static final int MAX_MINUTE = 60;


    private int hours;
    private int minutes;

    Time(int hours, int minutes) {
        if (hours < MIN_HOUR || hours > MAX_HOUR) {
            throw new IllegalStateException(String.format("Valid hours are between %s and %s", MIN_HOUR, MAX_HOUR));
        }

        if (minutes < MIN_MINUTE || minutes > MAX_MINUTE) {
            throw new IllegalStateException(String.format("Valid minutes are between %s and %s", MIN_MINUTE, MAX_MINUTE));
        }

        this.hours = hours;
        this.minutes = minutes;
    }

    public static Time of(int hours, int minutes) {
        return new Time(hours, minutes);
    }

    public boolean isAfter(Time time) {
        if (hours > time.hours) {
            return true;
        }
        if (hours == time.hours) {
            return minutes > time.minutes;
        }
        return false;
    }
}
