import java.util.HashMap;

// https://www.geeksforgeeks.org/largest-independent-set-problem-dp-26/

public class LargestIndependentSet {
    // for this question you can either include a node or exclude it
    // if you exlcude a node you have to include all its children
    // memoize this by saving the Largest Indepdent Set of a node if you have seen it before
    // the base case is 1
    public static int largestIndepdentSet(Node root) {
        HashMap<Node, Integer> visited = new HashMap<>();
        return largestSetHelper(root, visited);
    }

    public static int largestSetHelper(Node root, HashMap<Node, Integer> visited) {
        if (root == null) return 0;
        if (visited.containsKey(root)) return visited.get(root);
        if (root.left == null && root.right == null) {
            visited.put(root, 1);
            return 1;
        }

        int sizeExcluded = largestSetHelper(root.left, visited) + largestSetHelper(root.right. visited);

        int sizeIncluded = 1;
        if (root.left != null) {
            sizeIncluded += largestSetHelper(root.left.left, visited) + largestSetHelper(root.left.right, visited);
        }
        if (root.right != null) {
            sizeIncluded += largestSetHelper(root.right.left, visited) + largestSetHelper(root.right.right, visited);
        }
        visited.put(root, Math.max(sizeExcluded, sizeIncluded));
        return visited.get(root);
    }
}

class Node {
    Node left;
    Node right;
    int val;
}