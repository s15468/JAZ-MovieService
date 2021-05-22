package pl.pjatk.JulCho.Movie.Model;

import pl.pjatk.JulCho.Movie.Enums.MovieEnums;

public class Movie
{
    private String Name;
    private MovieEnums.Category Category;

    public Movie(String name, String category)
    {
        this.Name= name;
        this.Category = MovieEnums.Category.valueOf(category);
    }

    public String getName()
    {
        return Name;
    }

    public Enum getCategory()
    {
        return Category;
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
