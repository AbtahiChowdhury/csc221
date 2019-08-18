import java.util.Random;

public final class Navigator
{
    public static void navigate(int iterations, Node root)
    {
        Node currentnode = root;
        String direction;
        int randnum=0;
        Random rand = new Random();
        int probability=root.getProbability();
        int height=BinomialTreeFactory.getHeight(root);
        System.out.println("If RandNum is less than "+probability+" then it goes up the path. Otherwise\nit goes down the path.\n");
        
        for (int i=0; i<iterations; i++)
        {
            currentnode=root;
            System.out.println("Iteration "+(i+1));
            for (int j=0; j<height; j++)
            {
                randnum = rand.nextInt(101);
                if (randnum <= probability)
                {
                    //goesup
                    currentnode = currentnode.getLeftChild();
                    direction = "UP";
                }
                else
                {
                    //goesdown
                    currentnode = currentnode.getRightChild();
                    direction = "DOWN";
                }
                System.out.println("T="+currentnode.getTime()+"\t"+direction+"\tRandNum="+randnum);
            }
            System.out.println();
        }
    }
}