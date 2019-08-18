import java.util.Comparator;

public class sortByDirector implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return a.getDirector().compareTo(b.getDirector());
    }
}