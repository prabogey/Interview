import java.util.*;

// https://www.techiedelight.com/print-corner-nodes-every-level-binary-tree/
public class BSTPrintCornerNodesOfEveryLevel {
    // do a level order traversal
    // print the first node and the last node you see
    public static void printCornerNodes(BSTNode root) {
        if (root == null) return;
        Queue<BSTNode> currLevel = new LinkedList<>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            Queue<BSTNode> newLevel = new LinkedList<>();
            int size = currLevel.size();
            int i = 0;
            while(!currLevel.isEmpty()) {
                BSTNode curr = currLevel.remove();
                if (i == 0 || i == (size - 1)) {
                    System.out.print(curr.val + ", ");
                }
                if (curr.left != null) newLevel.add(curr.left);
                if (curr.right != null) newLevel.add(curr.right);
                i++;
            }
            System.out.println();
            currLevel = newLevel;
        }
    }

    public static void main(String[] args) {
        /**
         *          3
         *       /     \
         *      1       5
         *       \     / \
         *        2   4   6
         */
        BSTNode node1 = new BSTNode(1);
        BSTNode node2 = new BSTNode(2);
        BSTNode node3 = new BSTNode(3);
        BSTNode node4 = new BSTNode(4);
        BSTNode node5 = new BSTNode(5);
        BSTNode node6 = new BSTNode(6);
        node3.left = node1;
        node3.right = node5;
        node1.right = node2;
        node5.left = node4;
        node5.right = node6;
        
        printCornerNodes(node3);
  }
}