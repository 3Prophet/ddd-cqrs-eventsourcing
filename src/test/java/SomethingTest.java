import com.cinemax.controller.Controller;
import com.cinemax.domain.values.Date;
import com.cinemax.domain.values.Movie;
import com.cinemax.domain.values.ScreeningTime;
import com.cinemax.domain.values.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;

public class SomethingTest {

    Controller controller;

    @BeforeEach
    public void setUp() {
        controller = Mockito.mock(Controller.class);
        when(controller.getMoviesForDayAndTime(any(), any())).thenReturn(
                Arrays.asList(
                        Movie.of("The Heat", Date.of(21, 12, 2020), ScreeningTime.between(Time.of(10, 20), Time.of(12, 20))),
                        Movie.of("Harry Potter", Date.of(21, 12, 2020), ScreeningTime.between(Time.of(10, 20), Time.of(12, 20))))
        );
    }

    @Test
    void when_user_selects_day_and_time_he_sees_movies_in_time_interval_with_title_and_screening_times() {
        Date date = Date.of(21, 12, 2020);
        Time time = Time.of(9, 20);
        List<Movie> movies = controller.getMoviesForDayAndTime(date, time);
        for (Movie movie : movies) {
            assertThat(movie.startsAtDate(date), is(true));
            assertThat(movie.startsAfter(time), is(true));
        }
    }
}
