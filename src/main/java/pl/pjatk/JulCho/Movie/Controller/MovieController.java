package pl.pjatk.JulCho.Movie.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JulCho.Movie.Model.Movie;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
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
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("")
    public ResponseEntity<Movie> addMovieToList(@RequestBody Movie movie)
    {
        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> putMovieById(@PathVariable String id, @RequestBody Movie movie)
    {
        if (movie != null && id != null)
            return ResponseEntity.ok(movie);
        else
            return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable String id)
    {
        if (id != null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}
