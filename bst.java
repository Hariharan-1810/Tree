public class bst
{
    public static class node
    {
        int data;
        node left;
        node right;
    }
    static node top;

    public static node build(int a[], int left, int right)
    {
        if(left > right)
        {
            return null;
        }
        int mid = (left + right) / 2;

        node nn = new node();
        nn.data = a[mid];
        nn.left = build(a, left, mid - 1);
        nn.right = build(a, mid + 1, right);
        return nn;
    }

    public static void display(node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data+" ");

        display(root.left);
        display(root.right);
    }


    public static void main(String[] args)
    {
        int a[] = {10, 20, 30, 40, 50, 60, 70};

        int left = 0;
        int right = a.length - 1;

        top = build(a, left, right);

        display(top);
    }
}