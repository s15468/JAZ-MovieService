package pl.pjatk.JulCho.Movie.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JulCho.Movie.Model.Movies;
import pl.pjatk.JulCho.Movie.Service.MovieService;
import pl.pjatk.JulCho.Utils.Utils;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    private final MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping("")
    public ResponseEntity<List<Movies>> GetAllMovies()
    {
        return ResponseEntity.ok(movieService.GetMoviesList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> GetMovieById(@PathVariable String id)
    {
        Integer index = Utils.TryParseInt(id);

        if (index == null)
            return ResponseEntity.badRequest().build();

        Movies movie = movieService.GetMovieById(index);

        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("")
    public ResponseEntity<Movies> AddMovieToList(@RequestBody Movies movie)
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
    public ResponseEntity<Movies> PutMovieById(@PathVariable String id, @RequestBody Movies movie)
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
