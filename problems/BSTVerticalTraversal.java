import java.util.*;

// https://www.techiedelight.com/vertical-traversal-binary-tree/

public class BSTVerticalTraversal {
    public static void traverseVertically(BSTNode root) {
        HashMap<Integer, List<BSTNode>> traversal = new HashMap<>();
        List<BSTNode> rootList = new ArrayList<>();
        rootList.add(root);
        traversal.put(0, rootList);
        verticalHelper(root.left, -1, traversal);
        verticalHelper(root.right, 1, traversal);

        // print it
        List<Integer> sortedList = new ArrayList<Integer>(traversal.keySet());
        Collections.sort(sortedList);
        for (Integer key : sortedList) {
            for (BSTNode node : traversal.get(key)) {
                System.out.print(node.val + ", ");
            }
            System.out.println();
        }
    }

    public static void verticalHelper(BSTNode root, int distance, HashMap<Integer, List<BSTNode>> traversal) {
        if (root == null) return;
        List<BSTNode> rootList;
        if (traversal.containsKey(distance)) rootList = traversal.get(distance);
        else rootList = new ArrayList<>();
        rootList.add(root);
        traversal.put(distance, rootList);
        int leftDistance = distance - 1;
        int rightDistance = distance + 1;
        verticalHelper(root.left, leftDistance, traversal);
        verticalHelper(root.right, rightDistance, traversal);
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
        
        traverseVertically(node3);
  }
}