package pl.pjatk.JulCho.Movie.Model;

import pl.pjatk.JulCho.Movie.Enums.Category;
import javax.persistence.*;
import java.sql.Types;

@Entity
public class Movies
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String Name;
    @Enumerated(EnumType.STRING)
    private Category Category;
    private int is_available;

    public Category getCategory()
    {
        return Category;
    }

    public void setCategory(Category category)
    {
        Category = category;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public void setIsAvailable() {
        this.is_available = 1;
    }

    public int getIsAvailable()
    {
        return is_available;
    }
}
