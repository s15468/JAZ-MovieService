package pl.pjatk.JulCho.Movie.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JulCho.Movie.Model.Movie;

import java.io.InterruptedIOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieService
{
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        List<Movie> moviesList = List.of(
            new Movie(1, "test", "test"),
            new Movie(2, "Test2", "test2")
        );

        return ResponseEntity.ok(moviesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id)
    {
        if (Integer.parseInt(id) == 1)
            return ResponseEntity.ok(new Movie(1, "Test","Test"));
        else
            return (ResponseEntity<Movie>) ResponseEntity.badRequest();
    }

    @PostMapping("")
    public ResponseEntity<Movie> addMovieToList(@RequestBody Movie movie)
    {
        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return (ResponseEntity<Movie>) ResponseEntity.badRequest();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> putMovieById(@PathVariable String id, @RequestBody Movie movie)
    {
        if (movie != null && id != null)
            return ResponseEntity.ok(movie);
        else
            return (ResponseEntity<Movie>) ResponseEntity.badRequest();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable String id)
    {
        if (id != null)
            return (ResponseEntity<Void>) ResponseEntity.noContent();
        else
            return (ResponseEntity<Void>) ResponseEntity.notFound();
    }
}
