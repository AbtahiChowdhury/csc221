import java.util.Comparator;

public class sortByTitle implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return a.getTitle().compareTo(b.getTitle());
    }
}