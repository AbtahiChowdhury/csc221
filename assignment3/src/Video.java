import java.util.Date;

public class Video extends MultiMediaItem
{
    String director;

    public Video(String idin, String titlein, Date addedonin, int playingtimein, String directorin)
    {
        super(idin, titlein, addedonin, playingtimein);
        director = directorin;
    }

    @Override
    public String getDirector()
    {
        return director;
    }
}