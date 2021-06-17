package pl.pjatk.JulCho.Movie.Service;

import org.springframework.stereotype.Service;
import pl.pjatk.JulCho.Movie.Model.Movies;
import pl.pjatk.JulCho.Movie.Repository.MovieRepository;
import java.util.List;

@Service
public class MovieService
{
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    public void AddMovie(Movies movie)
    {
        movieRepository.InsertMovie(movie.getName(), movie.getCategory().toString());
    }

    public List<Movies> GetMoviesList()
    {
        return movieRepository.FindAllMovies();
    }

    public Movies GetMovieById(int index)
    {
        return movieRepository.FindByMovieId(index);
    }

    public Boolean PutMovieById(Integer index, Movies movie)
    {
        if (movie == null)
            return false;

        if (index != null)
            movieRepository.InsertMovie(index, movie.getName(), movie.getCategory().toString());

        return true;
    }

    public void DeleteMovieById(Integer index)
    {
        movieRepository.DeleteMovieById(index);
    }

    public void SetAvailableToTrue()
    {
        movieRepository.SetAvailableToTrue(1);
    }
}
