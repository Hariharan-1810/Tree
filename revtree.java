//reverse odd order of tree

import java.util.*;

public class revtree
{
    public static class node
    {
        int data;
        node left;
        node right;
    }

    static int id = -1;
    static int i = 0;
    static int cnt = 1;
    static int left = 0, right = 0;

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


    static Queue<node> nq = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void levelorder(node root)
    {
        if(root == null)
        {
            return;
        }

        nq.add(root);
        ArrayList<Integer> templist = new ArrayList<>();

        while(!nq.isEmpty())
        {
            node temp = nq.poll();
            templist.add(temp.data);

            if(temp.left!= null)
            {
                nq.add(temp.left);
                left++;
            }

            if(temp.right!= null)
            {
                nq.add(temp.right);
                right++;
            }

            cnt--;

            if(cnt == 0)
            {
                list.add(templist);
                templist = new ArrayList<>();
                cnt = left + right;
                left = 0;
                right = 0;
            }
        }
    }

    public static void display()
    {
        int len = list.size();
        for(int i = 0; i < len; i++)
        {
            ArrayList<Integer> temp = list.get(i);
            int size = temp.size();

            if(i % 2 == 1)
            {
                Collections.reverse(temp);
            }

            for(int j = 0; j < size; j++)
            {
                System.out.print(temp.get(j) + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int node[] = {1, 2, 4, 8, -1, -1, 9, -1, -1, 5, 10, -1, -1, 11, -1, -1, 3, 6, 12, -1, -1, 13, -1, -1, 7, 14, -1, -1, 15, -1, -1};

        node root = build(node);

        levelorder(root);
        
        display();

    }
}

