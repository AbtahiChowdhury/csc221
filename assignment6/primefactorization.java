import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class primefactorization
{
    public static boolean isPrime(int n)
    {
        if(n == 2)
        {
            return true;
        }
        if(n%2 == 0)
        {
            return false;
        }
        for(int i=3; i*i<=n; i+=2)
        {
            if(n%i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static HashSet<Integer> primeFactors(int n)
    {
        HashSet<Integer> primefactors = new HashSet<>();
        while(n%2 == 0)
        {
            primefactors.add(2);
            n /= 2;
        }
        for(int i=3; i<=Math.sqrt(n); i+=2)
        {
            while(n%i == 0)
            {
                primefactors.add(i);
                n /= i;
            }
        }
        if(n>2)
        {
            primefactors.add(n);
        }
        return primefactors;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = 1;
        System.out.println("Enter a number");
        while(true)
        {
            try
            {
                n = scan.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid number");
                break;
            }

            if(isPrime(n))
            {
                System.out.print(n + " is a prime number.");
            }
            else
            {
                System.out.print(primeFactors(n).toString());
            }
            System.out.println("\n");
        }
        scan.close();
    }
}