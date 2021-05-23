package pl.pjatk.JulCho.Movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.JulCho.Movie.Model.Movies;

public interface MovieRepository extends JpaRepository<Movies, Integer>
{
    Movies findBy(Integer id);
}
