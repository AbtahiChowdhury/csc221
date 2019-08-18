import java.util.ArrayList;
import java.util.Collections;

public class Database
{
    public ArrayList<Item> items;

    public Database()
    {
        items = new ArrayList<Item>();
    }

    public void addItem(Item itemin)
    {
        items.add(itemin);
    }

    public void sort()
    {
        Collections.sort(items);
    }
    
    public void list()
    {
        System.out.println("ID\tTitle\tDate\n");
        for (Item i : items)
        {
            System.out.println(i.getID()+"\t"+i.getTitle()+"\t"+i.getAddedOn());
        }
    }
}