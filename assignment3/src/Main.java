import java.util.Date;
import java.util.Collections;
import java.util.Calendar;

public class Main
{
    public static void main(String args[]) {
        Database library = new Database();
        Calendar cal = Calendar.getInstance();
      
        // adding database entries
        cal.set(1890, Calendar.AUGUST, 10);
        Date date = (Date) cal.getTime();
        library.addItem(new Textbook("TB15", "TextX", date, "John Doe"));
                      
        cal.set(1954, Calendar.JANUARY, 18);
        date = (Date) cal.getTime() ;
        library.addItem(new Video("V09", "VideoB", date, 70000, "J. Smith"));
                      
        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new Textbook("TB01", "TextY", date, "John Doe"));
                    
        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD07", "CD1", date, 1000, "B.D."));
                      
        cal.set(1990, Calendar.APRIL, 30);
        date = (Date) cal.getTime() ;
        library.addItem(new CD("CD10", "CD1", date, 800, "X.Y."));
                      
        cal.set(2000, Calendar.FEBRUARY, 29);
        date = (Date) cal.getTime();
        library.addItem(new CD("CD05", "CD1", date, 1000, "B.C."));
                      
        cal.set(1890, Calendar.JULY, 2);
        date = (Date) cal.getTime();
        library.addItem(new Video("V12", "VideoA", date, 7000, "Joe Smith"));
                      
        // print unsorted database
        System.out.println("----- DATABASE BEFORE SORTING: -----\n");
        library.list();
        System.out.println();

        // sort and print sorted database (by id)
        Collections.sort(library.items);
        System.out.println("----- DATABASE AFTER SORTING BY ID (default): -----\n");
        library.list();
        System.out.println();

        // sort by other fields
        System.out.println("----- DATABASE AFTER SORTING BY TITLE: -----\n");
        Collections.sort(library.items, new sortByTitle());   
        library.list();
        System.out.println();

        System.out.println("----- DATABASE AFTER SORTING BY ADDEDON: -----\n");
        Collections.sort(library.items, new sortByAddedOn());   
        library.list();
        System.out.println();

        System.out.println("----- DATABASE AFTER SORTING BY DIRECTOR: -----\n");
        Collections.sort(library.items, new sortByDirector());   
        library.list();
        System.out.println();

        System.out.println("----- DATABASE AFTER SORTING BY AUTHOR: -----\n");
        Collections.sort(library.items, new sortByAuthor());   
        library.list();
        System.out.println();

        System.out.println("----- DATABASE AFTER SORTING BY ARTIST: -----\n");
        Collections.sort(library.items, new sortByArtist());   
        library.list();
        System.out.println();

        System.out.println("----- DATABASE AFTER SORTING BY PLAYING TIME: -----\n");
        Collections.sort(library.items, new sortByPlayingTime());   
        library.list();
        System.out.println();
      }
}