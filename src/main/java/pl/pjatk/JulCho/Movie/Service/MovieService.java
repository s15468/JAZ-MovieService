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
        movieRepository.save(movie);
    }

    public List<Movies> GetMoviesList()
    {
        return movieRepository.findAll();
    }

    public Movies GetMovieById(int index)
    {
        return movieRepository.findBy(index);
    }

    public Boolean PutMovieById(Integer index, Movies movie)
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
        movieRepository.deleteById(index);
    }
}
