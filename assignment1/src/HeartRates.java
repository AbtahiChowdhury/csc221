import java.time.LocalDate;
import java.time.Period;

public class HeartRates
{
    private String firstName;
    private String lastName;
    private int dobMonth;
    private int dobDay;
    private int dobYear;

    public HeartRates(String firstNamein, String lastNamein, int dobMonthin, int dobDayin, int dobYearin)
    {
        firstName=firstNamein;
        lastName=lastNamein;
        dobMonth=dobMonthin;
        dobDay=dobDayin;
        dobYear=dobYearin;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();
        LocalDate dob = LocalDate.of(dobYear,dobMonth,dobDay);
        Period period = Period.between(dob,today);
        return period.getYears();
    }
    public int getMaximunHeartRate()
    {
        return 220 - getAge();
    }
    public String getTargetHeartRate()
    {
        int maxheartrate=getMaximunHeartRate();
        int mintargetheartrate=(int)(maxheartrate * 0.5);
        int maxtargetheartrate=(int)(maxheartrate * 0.85);
        return mintargetheartrate+"-"+maxtargetheartrate;
    }

    public void getFirstName(String firstNamein)
    {
        firstName=firstNamein;
    }
    public void getLastName(String lastNamein)
    {
        lastName=lastNamein;
    }
    public void getDoBMonth(int dobMonthin)
    {
        dobMonth=dobMonthin;
    }
    public void getDoBDay(int dobDayin)
    {
        dobDay=dobDayin;
    }
    public void getDoBYear(int dobYearin)
    {
        dobYear=dobYearin;
    }


    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getDoBMonth()
    {
        return dobMonth;
    }
    public int getDoBDay()
    {
        return dobDay;
    }
    public int getDoBYear()
    {
        return dobYear;
    }
}