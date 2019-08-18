import java.util.Comparator;

public class sortByAuthor implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return a.getAuthor().compareTo(b.getAuthor());
    }
}