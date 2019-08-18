import java.util.Date;

public abstract class MultiMediaItem extends Item
{
    int playingTime;

    public MultiMediaItem(String idin, String titlein, Date addedonin, int playingtimein)
    {
        super(idin, titlein, addedonin);
        playingTime= playingtimein;
    }

    @Override
    public int getPlayingTime()
    {
        return playingTime;
    }
}