public class tree
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
        sum++;
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args)
    {
        int node[] = {1, 2, 4, 8 ,-1, -1, 9, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};

        node root = build(node);

        preorder(root);
        
        System.out.println(sum);
    }
}

