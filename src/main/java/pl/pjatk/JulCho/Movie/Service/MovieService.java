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
    @ResponseBody
    public ResponseEntity<Movie> getMovieById(@PathVariable String id)
    {
        if (Integer.parseInt(id) == 1)
            return ResponseEntity.ok(new Movie(1, "Test","Test"));
        else
            return (ResponseEntity<Movie>) ResponseEntity.badRequest();
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Movie> addMovieToList(@RequestBody Movie movie)
    {
        if (movie != null)
            return ResponseEntity.ok(movie);
        else
            return (ResponseEntity<Movie>) ResponseEntity.badRequest();
}
}
