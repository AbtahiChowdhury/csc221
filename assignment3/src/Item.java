import java.util.Date;

public abstract class Item implements Comparable<Item>
{
    String id;
    String title;
    Date addedOn;

    public Item(String idin, String titlein, Date addedonin)
    {
        id = idin;
        title = titlein;
        addedOn = addedonin;
    }

    public int compareTo(Item itemin)
    {
        return id.compareTo(itemin.getID());
    }

    public String getID()
    {
        return id;
    }
    public String getTitle()
    {
        return title;
    }
    public Date getAddedOn()
    {
        return addedOn;
    }


    public String getAuthor()
    {
        return "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    }
    public int getPlayingTime()
    {
        return 2147483647;
    }
    public String getArtist()
    {
        return "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    }
    public String getDirector()
    {
        return "zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
    }
}