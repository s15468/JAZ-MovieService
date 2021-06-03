package pl.pjatk.JulCho.Movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.pjatk.JulCho.Movie.Model.Movies;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movies, Integer>
{
    @Query("SELECT m FROM Movies m")
    List<Movies> FindAllMovies();

    @Query("SELECT m FROM Movies m WHERE m.ID =?1")
    Movies FindByMovieId(Integer movieId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Movies (name, category) values (:moviesName, :moviesCategory)", nativeQuery = true)
    void InsertMovie(@Param("moviesName") String moviesName, @Param("moviesCategory") String moviesCategory);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Movies(id, name, category) values (:moviesId, :moviesName, :moviesCategory)", nativeQuery = true)
    void InsertMovie(@Param("moviesId") Integer moviesId, @Param("moviesName") String movieName, @Param("moviesCategory") String moviesCategory);

    @Transactional
    @Modifying
    @Query("delete from Movies m where m.ID=:id")
    void DeleteMovieById(@Param("id") Integer id);
}
