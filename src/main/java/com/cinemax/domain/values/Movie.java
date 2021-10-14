package com.cinemax.domain.values;

public class Movie {

    private String title;

    private Date date;

    private ScreeningTime screeningTime;

    private Movie(String title, Date date, ScreeningTime screeningTime) {
        this.date = date;
        this.title = title;
        this.screeningTime = screeningTime;
    }

    public static Movie of(String title, Date date, ScreeningTime screeningTime) {
        return new Movie(title, date, screeningTime);
    }

    public boolean startsAtDate(Date date) {
        return date.equals(date);
    }

    public boolean startsAfter(Time time) {
        return screeningTime.start().isAfter(time);
    }
}
