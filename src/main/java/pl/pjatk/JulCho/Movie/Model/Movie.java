package pl.pjatk.JulCho.Movie.Model;

import pl.pjatk.JulCho.Movie.Enums.MovieEnums;

public class Movie {

    private long Id;
    private String Name;
    private MovieEnums.Category Category;

    public Movie(String name, String category)
    {
        this.Id = 1;
        this.Name= name;
        this.Category = MovieEnums.Category.valueOf(category);
    }

    public long getId()
    {
        return Id;
    }

    public String getName()
    {
        return Name;
    }

    public Enum getCategory()
    {
        return Category;
    }

    public void setId(long id)
    {
        this.Id = id;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public void setCategory(String category)
    {
        this.Category = MovieEnums.Category.valueOf(category);
    }
}
