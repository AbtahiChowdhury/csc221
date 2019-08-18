import java.util.InputMismatchException;
import java.util.Scanner;

public class HeartRatesDriver
{
    public static void main(String[] args)
    {
        String firstname="", lastname="";
        int dobmonth=0, dobday=0, dobyear=0;
        Scanner scan = new Scanner(System.in);
        
        try
        {
            System.out.println("What is your first name?");
            firstname=scan.nextLine();
            System.out.println("What is your last name?");
            lastname=scan.nextLine();
            System.out.println("What is the month of your birth?");
            dobmonth=scan.nextInt();
            System.out.println("What is the day of your birth?");
            dobday=scan.nextInt();
            System.out.println("What is the year of your birth?");
            dobyear=scan.nextInt();
        } 
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input. Expexted an integer.");
            scan.close();
            return;
        }
        if(firstname.isEmpty() || lastname.isEmpty())
        {
            System.out.println("Invalid input. Did not enter a name.");
            scan.close();
            return;
        }
        if(dobmonth>12 || dobmonth<1 || dobday>31 || dobday<1 || dobyear<1900)
        {
            System.out.println("Invalid date.");
            scan.close();
            return;
        }

        HeartRates myheartrates = new HeartRates(firstname,lastname,dobmonth,dobday,dobyear);
        System.out.println("Maximun Heart Rate: "+myheartrates.getMaximunHeartRate());
        System.out.println("Target Heart Rates: "+myheartrates.getTargetHeartRate());

        scan.close();
    }
}