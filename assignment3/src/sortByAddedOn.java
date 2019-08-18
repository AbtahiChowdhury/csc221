import java.util.Comparator;

public class sortByAddedOn implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return a.getAddedOn().compareTo(b.getAddedOn());
    }
}