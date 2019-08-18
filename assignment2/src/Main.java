import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int treeheight,probability,iterations;

        try
        {
            System.out.print("Tree height=");
            treeheight = scan.nextInt();
            System.out.println();

            System.out.print("Probability to go up=");
            probability = scan.nextInt();
            System.out.println();

            System.out.print("Iterations to navigate=");
            iterations = scan.nextInt();
            System.out.println();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Invalid input. Expexted an integer.");
            scan.close();
            return;
        }
        if (iterations>treeheight)
        {
            System.out.println("Invalid input. Number of iterations is greater\nthan height of the tree.");
            scan.close();
            return;
        }
        clearScreen();

        Node root = BinomialTreeFactory.create(treeheight,probability);
        //System.out.println(BinomialTreeFactory.getHeight(root));
        //BinomialTreeFactory.printTree(root);
        Navigator.navigate(iterations,root);
        scan.close();
    }
}