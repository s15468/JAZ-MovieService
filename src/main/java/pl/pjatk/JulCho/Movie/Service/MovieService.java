package pl.pjatk.JulCho.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.JulCho.Movie.Model.Movie;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService
{
    public List<Movie> moviesList;

    public MovieService()
    {
        moviesList = Arrays.asList(
                new Movie("Test", "Action"),
                new Movie("Test1", "Family")
        );
    }
}
