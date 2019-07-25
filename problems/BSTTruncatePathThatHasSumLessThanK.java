import java.util.*;

public class BSTTruncatePathThatHasSumLessThanK {
    public static BSTNode truncate(BSTNode root, int k) {
        if (root.val >= k) return root;

        boolean left = helper(root.left, root.val, k);
        boolean right = helper(root.right, root.val, k);
        
        if (left == false && right == false) return null;
        if (left == false) root.left = null;
        if (right == false) root.right = null;

        return root;
    }

    public static boolean helper(BSTNode root, int sum, int k) {
        if (root == null) return false;
        if (root.val + sum >= k) return true;

        boolean left = helper(root.left, sum + root.val, k);
        boolean right = helper(root.right, sum + root.val, k);

        if (left == false && right == false) return false;
        if (left == false) root.left = null;
        if (right == false) root.right = null;

        return true;
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
        
        truncate(node3, 12);

        Queue<BSTNode> curr = new LinkedList<>();
        curr.add(node3);
        // should print 3,5,4,6
        while (!curr.isEmpty()) {
            BSTNode root = curr.remove();
            System.out.println(root.val);
            if (root.left != null) curr.add(root.left);
            if (root.right != null) curr.add(root.right);
        }
    }
}