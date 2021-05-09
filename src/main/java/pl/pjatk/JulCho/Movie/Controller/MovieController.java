package pl.pjatk.JulCho.Movie.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.JulCho.Movie.Model.Movie;
import pl.pjatk.JulCho.Movie.Service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return ResponseEntity.ok(new MovieService().moviesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable String id)
    {
        if (Integer.parseInt(id) == 1)
            return ResponseEntity.ok(new Movie("Test","Test"));
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
