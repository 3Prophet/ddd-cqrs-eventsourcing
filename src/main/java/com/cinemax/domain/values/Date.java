package com.cinemax.domain.values;

import java.time.LocalDate;
import java.util.Objects;

public class Date {

    private LocalDate localDate;

    public Date(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static Date of(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        return new Date(localDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return localDate.equals(date.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate);
    }
}
