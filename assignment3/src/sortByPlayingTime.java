import java.util.Comparator;

public class sortByPlayingTime implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return (new Integer(a.getPlayingTime()).compareTo(b.getPlayingTime()));
    }
}