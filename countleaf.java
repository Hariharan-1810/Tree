public class countleaf
{
    public static class node
    {
        int data;
        node left;
        node right;
    }

    static int id = -1;
    static int sum = 0;

    public static node build(int a[])
    {
        id++;
        if (id >= a.length || a[id] == -1)
        {
            return null;
        }

        node nn = new node();
        nn.data = a[id];
        nn.left = build(a);
        nn.right = build(a);
        return nn;
    }

    public static void preorder(node root)
    {
        if(root == null)
        {
            return;
        }
        if(root.left == null && root.right == null)
        {
            sum = sum + root.data;
        }
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args)
    {
        int node[] = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11, -1, -1, 3, 6, 12, -1, -1, 13, -1, -1, 7, 14, -1, -1, 15, -1, -1};

        node root = build(node);

        preorder(root);
        
        System.out.println(sum);
    }
}

