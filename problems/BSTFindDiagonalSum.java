import java.util.*;

// https://www.techiedelight.com/find-diagonal-sum-given-binary-tree/
public class BSTFindDiagonalSum {
    // intuition here lies in how the tree is described to you
    // the problem states that the left and right child of a node make 45 degree angles with the parent
    // this means that given a root, its left child will be in the same diagonal as its right childs left child
    // this means that we can just go through the tree in preorder fashion
    // we start at a digonal ID of 0, whenever we go to the left we add 1 to this ID (new diagonal) and whenever we go
    // to the right we pass the same ID down (same diagonal)
    public static void findDiagonalSum(BSTNode root) {
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0, root.val);
        helper(root.left, -1, sums);
        helper(root.right, 0, sums);

        // print it
        for (Integer key : sums.keySet()) {
            System.out.println(key + ": " + sums.get(key));
        }
    }

    public static void helper(BSTNode root, int diagonal, HashMap<Integer, Integer> sums) {
        if (root == null) return;
        int currSum = sums.getOrDefault(diagonal, 0);
        sums.put(diagonal, currSum + root.val);
        helper(root.left, diagonal - 1, sums);
        helper(root.right, diagonal, sums);
    }

    public static void main(String[] args) {
        /**
         *          3
         *       /     \
         *      1       5
         *       \
         *        2
         */
        BSTNode node1 = new BSTNode(1);
        BSTNode node3 = new BSTNode(3);
        BSTNode node5 = new BSTNode(5);
        BSTNode node2 = new BSTNode(2);
        node3.left = node1;
        node3.right = node5;
        node1.right = node2;
        
        findDiagonalSum(node3);
  }

}