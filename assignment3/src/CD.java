import java.util.Date;

public class CD extends MultiMediaItem
{
    String artist;

    public CD(String idin, String titlein, Date addedonin, int playingtimein, String artistin)
    {
        super(idin, titlein, addedonin, playingtimein);
        artist = artistin;
    }

    @Override
    public String getArtist()
    {
        return artist;
    }
}