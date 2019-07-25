import java.util.*;

// https://www.techiedelight.com/convert-binary-tree-to-bst-maintaining-original-structure/

public class BSTConvertBTToBSTMaintainOriginalStructure {
    public static BSTNode converter(BSTNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Stack<BSTNode> stac = new Stack<>();
        stac.push(root);
        System.out.println("Starting with this shit");
        while (!stac.isEmpty()) {
            BSTNode curr = stac.pop();
            pq.add(curr.val);
            if (curr.left != null) stac.push(curr.left);
            if (curr.right != null) stac.push(curr.right);
        }

        Iterator<Integer> it = pq.iterator();
        helper(root.left, it);
        int x = it.next();
        System.out.println(x);
        root.val = x;
        helper(root.right, it);

        System.out.println();
        return root;
    }

    public static void helper(BSTNode root, Iterator<Integer> it) {
        if (root == null) return;
        helper(root.left, it);
        int x = it.next();
        System.out.println(x);
        root.val = x;
        helper(root.right, it);
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
        node3.left = node5;
        node3.right = node1;
        node1.left = node6;
        node5.right = node4;
        node1.right = node2;
        
        BSTNode root = converter(node3);

        Queue<BSTNode> curr = new LinkedList<>();
        curr.add(root);
        // should print 3, 1, 5, 2, 4, 6
        while (!curr.isEmpty()) {
            root = curr.remove();
            System.out.println(root.val);
            if (root.left != null) curr.add(root.left);
            if (root.right != null) curr.add(root.right);
        }
    }
}