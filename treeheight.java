public class treeheight
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

    public static int find(node root)
    {
        if(root == null)
        {
            return 0;
        }
        return Math.max(find(root.left), find(root.right) ) + 1;
    }

    public static void main(String[] args)
    {
        int a[] = {5, 3, 1, 4, 2, 7, 6, 8};

        for(int i = 0; i < a.length; i++)
        {
            build(a[i], top);
        }
        System.out.println(find(top));
    }
}
