package com.cinemax.domain.values;

public class ScreeningTime {

    private final Time start;

    private final Time end;

    private  ScreeningTime(Time start, Time end ) {
        this.start = start;
        this.end = end;
    }

    public Time start() {
        return start;
    }

    public static ScreeningTime between(Time start, Time end) {
        return new ScreeningTime(start, end);
    }
}
