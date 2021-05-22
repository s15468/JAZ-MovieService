package pl.pjatk.JulCho.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.JulCho.Movie.Model.Movie;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService
{
    private ArrayList<Movie> moviesList;

    public MovieService()
    {
        moviesList = new ArrayList<>();
    }

    public void AddMovie(Movie movie)
    {
        moviesList.add(movie);
    }

    public List<Movie> GetMoviesList()
    {
        return moviesList;
    }

    public Movie GetMovieById(int index)
    {
        if (index <= moviesList.size())
            return moviesList.get(index);
        else
            return null;
    }

    public Boolean PutMovieById(Integer index, Movie movie)
    {
        if (movie == null)
            return false;

        if (index == null)
            moviesList.add(movie);
        else
            moviesList.add(index, movie);

        return true;
    }

    public void DeleteMovieById(Integer index)
    {
        if (index <= moviesList.size())
        {
            moviesList.remove(index);
        }
    }
}
