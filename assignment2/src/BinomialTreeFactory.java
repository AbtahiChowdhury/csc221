public final class BinomialTreeFactory
{
    public static Node create(int time, int probability)
    {
        Node root = new Node(0,probability);
        createaux(time,probability,0,root);
        return root;
    }

    private static void createaux(int time, int probability, int iteration, Node root)
    {
        if (time==iteration)
        {
            return;
        }
        root.setRightChild(new Node(iteration+1,100-probability));
        root.setLeftChild(new Node(iteration+1,probability));
        createaux(time,probability,iteration+1,root.getRightChild());
        createaux(time,probability,iteration+1,root.getLeftChild());
    }

    public static int getHeight(Node root)
    {
        Node currentnode = root;
        int height=0;
        while(currentnode!=null)
        {
            currentnode=currentnode.getLeftChild();
            height++;
        }
        return height-1;
    }

    public static void printTree(Node root)
    {
        if (root!=null)
        {
            printTree(root.getLeftChild());
            System.out.print("\t");
            for (int i=0; i<root.getTime(); i++)
            {
                System.out.print('\t');
            }
            System.out.println(root.getTime()+" "+root.getProbability()+"%");
            printTree(root.getRightChild());
        }
    }
}