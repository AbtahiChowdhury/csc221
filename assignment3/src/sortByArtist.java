import java.util.Comparator;

public class sortByArtist implements Comparator<Item>
{
    public int compare(Item a, Item b)
    {
        return a.getArtist().compareTo(b.getArtist());
    }
}