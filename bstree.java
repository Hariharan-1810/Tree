public class bstree
{
    public static class node
    {
        int data;
        node left;
        node right;
    }
    static node top = null;

    public static void build(int num, node root)
    {
        node nn = new node();
        nn.data = num;
        nn.left = null;
        nn.right = null;
        
        if(top == null)
        {
            top = nn;
        }
        else
        {
            if(root.data > num)
            {
                if(root.left == null)
                {
                    root.left = nn;
                }
                else
                {
                    build(num, root.left);
                }
            }
            if(root.data <= num)
            {
                if(root.right == null)
                {
                    root.right = nn;
                }
                else
                {
                    build(num, root.right);
                }
            }
        }
    }

    public static void display(node root)
    {
        if(root == null)
        {
            return;
        }

        display(root.left);

        System.out.print(root.data+" ");

        display(root.right);
    }

    public static void main(String[] args)
    {
        int a[] = {5, 3, 1, 4, 2, 7, 6, 8};

        for(int i = 0; i < a.length; i++)
        {
            build(a[i], top);
        }
        display(top);
    }
}
