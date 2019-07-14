import java.util.*;

public class BSTFromPostorder {
    public static BSTNode construct(List<BSTNode> postorder) {
        int last = postorder.size() - 1;
        int val = postorder.get(last).val;
        BSTNode root = new BSTNode(val);
        Index index = new Index(--last);
        root.right = helper(postorder, index, val, Integer.MAX_VALUE);
        root.left = helper(postorder, index, Integer.MIN_VALUE, val);
        return root;
    }

    public static BSTNode helper(List<BSTNode> postorder, Index index, int min, int max) {
        if (index.val < 0 || index.val >= postorder.size()) return null;
        BSTNode curr = postorder.get(index.val);
        if (curr.val < min || curr.val > max) {
            return null;
        }
        index.val = --index.val;
        BSTNode root = new BSTNode(curr.val);
        root.right = helper(postorder, index, curr.val, max);
        root.left = helper(postorder, index, min, curr.val);
        return root;
    }

    public static void main(String[] args) {
        BSTNode node1 = new BSTNode(1);
        BSTNode node2 = new BSTNode(2);
        BSTNode node3 = new BSTNode(3);
        node2.left = node1;
        node2.right = node3;

        List<BSTNode> postOrder = new ArrayList<>();
        postOrder.add(node1);
        postOrder.add(node3);
        postOrder.add(node2);

        BSTNode root = construct(postOrder);
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BSTNode curr = q.remove();
            System.out.println(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    static class Index {
        int val;

        public Index(int val) {
            this.val = val;
        }
    }
}