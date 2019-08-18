public class Node
{
    private int time;
    private int prob;
    private Node leftchild;
    private Node rightchild;

    public Node(int timein, int probabilityin)
    {
        time=timein;
        prob=probabilityin;
        leftchild=null;
        rightchild=null;
    }
    
    public int getTime()
    {
        return time;
    }
    public int getProbability()
    {
        return prob;
    }
    public Node getLeftChild()
    {
        return leftchild;
    }
    public Node getRightChild()
    {
        return rightchild;
    }
    
    public void setTime(int timein)
    {
        time=timein;
    }
    public void setProbability(int probabilityin)
    {
        prob=probabilityin;
    }
    public void setLeftChild(Node leftchildin)
    {
        leftchild=leftchildin;
    }
    public void setRightChild(Node rightchildin)
    {
        rightchild=rightchildin;
    }
}