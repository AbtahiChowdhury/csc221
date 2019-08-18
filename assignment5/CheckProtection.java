import java.util.Scanner;
import java.util.Arrays;
import java.lang.reflect.Array;

public class CheckProtection
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String amountstring = scan.nextLine();
        if(!amountstring.contains("."))
        {
            amountstring = amountstring.concat(".00");
        }

        try
        {
            Double.parseDouble(amountstring);
        }
        catch (Exception e)
        {
            System.out.println("Invalid Input");
            scan.close();
            return;
        }

        if(amountstring.length() > 9)
        {
            System.out.println("Maximun Character Limit Reached");
            scan.close();
            return;
        }
        
        char[] amount = amountstring.toCharArray();
        char[] stars = new char[9-amount.length];
        char[] print = (char[]) Array.newInstance(stars.getClass().getComponentType(),amount.length+stars.length);
        Arrays.fill(stars, '*');
        System.arraycopy(stars,0,print,0,stars.length);
        System.arraycopy(amount,0,print,stars.length,amount.length);
        StringBuilder builder = new StringBuilder(print.length);
        for (char i : print)
        {
            builder.append(i);
        }
        System.out.println(builder.toString());
        scan.close();
    }
}