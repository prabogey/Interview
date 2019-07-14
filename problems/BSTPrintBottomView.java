// https://www.techiedelight.com/print-bottom-view-of-binary-tree/
// Print the last node in each level that is x horizontal distance from the root for all values of x
import java.util.*;

public class BSTPrintBottomView {
    public static void printBottomView(BSTNode root) {
        HashMap<Integer, BSTNode> levelMap = new HashMap<>();
        levelMap.put(0, root);
        System.out.println("Distance: " + 0 + ", Value: " + root.val);
        helper(root.left, -1, levelMap);
        helper(root.right, 1, levelMap);
        printLevelMap(levelMap);
        return;
    }

    public static void helper(BSTNode root, int distance, HashMap<Integer, BSTNode> levelMap) {
        if (root == null) return;
        levelMap.put(distance, root);
        System.out.println("Distance: " + distance + ", Value: " + root.val);
        helper(root.left, distance - 1, levelMap);
        helper(root.right, distance + 1, levelMap);
    }

    public static void printLevelMap(HashMap<Integer, BSTNode> levelMap) {
        ArrayList<Integer> sorted = new ArrayList<>(levelMap.keySet());
        Collections.sort(sorted);
        for (Integer key : sorted) {
            System.out.print(levelMap.get(key).val);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BSTNode node1 = new BSTNode(1);
        BSTNode node3 = new BSTNode(3);
        BSTNode node5 = new BSTNode(5);
        BSTNode node2 = new BSTNode(2);
        node3.left = node1;
        node3.right = node5;
        node1.right = node2;

        printBottomView(node3);
    }

}