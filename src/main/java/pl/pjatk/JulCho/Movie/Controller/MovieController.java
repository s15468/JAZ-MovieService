package pl.pjatk.JulCho.Movie.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JulCho.Movie.Model.Movie;
import pl.pjatk.JulCho.Movie.Service.MovieService;
import pl.pjatk.JulCho.Utils.Utils;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    private MovieService movieService = new MovieService();

    @GetMapping("")
    public ResponseEntity<List<Movie>> GetAllMovies()
    {
        return ResponseEntity.ok(movieService.GetMoviesList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> GetMovieById(@PathVariable String id)
    {
        Integer index = Utils.TryParseInt(id);

        if (index == null)
            return ResponseEntity.badRequest().build();

        Movie movie = movieService.GetMovieById(index);

        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("")
    public ResponseEntity<Movie> AddMovieToList(@RequestBody Movie movie)
    {
        if (movie != null)
        {
            movieService.AddMovie(movie);
            return ResponseEntity.ok(movie);
        }
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> PutMovieById(@PathVariable String id, @RequestBody Movie movie)
    {
        Integer index = Utils.TryParseInt(id);

        if (movieService.PutMovieById(index, movie))
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteMovieById(@PathVariable String id)
    {
        Integer index = Utils.TryParseInt(id);

        if (index != null)
        {
            movieService.DeleteMovieById(index);
            return ResponseEntity.ok().build();
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
