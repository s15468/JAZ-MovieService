package pl.pjatk.JulCho.Movie.Model;

public class Movie {

    private int Id;
    private String Name;
    private String Category;

    public Movie(int id, String name, String category)
    {
        this.Id = id;
        this.Name = name;
        this.Category = category;
    }

    public Movie(String name, String category)
    {
        this.Id = 1;
        this.Name= name;
        this.Category = category;
    }

    public int getId()
    {
        return Id;
    }

    public String getName()
    {
        return Name;
    }

    public String getCategory()
    {
        return Category;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public void setCategory(String category)
    {
        this.Category = category;
    }
}
