public class BinaryTreeSpiral {
    void printSpiral(Node node) 
    {
        int h = height(node);
        int i;
  
        /* ltr -> left to right. If this variable is set then the
           given label is transversed from left to right */
        boolean ltr = false;
        for (i = 1; i <= h; i++) 
        {
            printGivenLevel(node, i, ltr);
  
            /*Revert ltr to traverse next level in opposite order*/
            ltr = !ltr;
        }
  
    }
  
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node node) 
    {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
  
    /* Print nodes at a given level */
    void printGivenLevel(Node node, int level, boolean ltr) 
    {
        if (node == null) 
            return;
        if (level == 1) 
            System.out.print(node.data + " ");
        else if (level > 1) 
        {
            if (ltr != false) 
            {
                printGivenLevel(node.left, level - 1, ltr);
                printGivenLevel(node.right, level - 1, ltr);
            } 
            else
            {
                printGivenLevel(node.right, level - 1, ltr);
                printGivenLevel(node.left, level - 1, ltr);
            }
        }
    }
}