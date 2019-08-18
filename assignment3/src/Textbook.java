import java.util.Date;

public class Textbook extends Item
{
    private String author;

    public Textbook(String idin, String titlein, Date addedonin, String authorin)
    {
        super(idin, titlein, addedonin);
        author = authorin;
    }

    @Override
    public String getAuthor()
    {
        return author;
    }
}