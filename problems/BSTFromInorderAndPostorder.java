import java.util.*;

public class BSTFromInorderAndPostorder {
    public static BSTNode constructTree(List<BSTNode> inorder, List<BSTNode> postorder) {
        HashMap<BSTNode, Integer> enumInorder = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            enumInorder.put(inorder.get(i), i);
        }

        BSTNode last = postorder.get(postorder.size() - 1);
        BSTNode root = new BSTNode(last.val);
        int left = enumInorder.get(last);
        int right = left++;
        Index index = new Index(postorder.size() - 2);
        BSTNode rightNode = helper(postorder, enumInorder, index, right, inorder.size());
        BSTNode leftNode = helper(postorder, enumInorder, index, 0, left);
        root.right = rightNode;
        root.left = leftNode;
        return root;
    }

    public static BSTNode helper(List<BSTNode> postorder, HashMap<BSTNode, Integer> enumInorder, Index index, int left, int right) {
        if (index.index < 0 || index.index >= postorder.size()) return null;
        int nodeIndex = enumInorder.get(postorder.get(index.index)); // finding the index from the inorder
        if (nodeIndex < left || nodeIndex >= right) return null; // if its index is not in the bounds then dont create it here
        BSTNode root = new BSTNode(postorder.get(index.index).val); // creating new root node
        index.index = --index.index;
        int newLeft = nodeIndex++;
        root.right = helper(postorder, enumInorder, index, newLeft, right);
        root.left = helper(postorder, enumInorder, index, right, nodeIndex);
        return root;
    }

    public static void main(String[] args) {
        BSTNode node1 = new BSTNode(1);
        BSTNode node2 = new BSTNode(2);
        BSTNode node3 = new BSTNode(3);
        node1.left = node2;
        node1.right = node3;

        List<BSTNode> postOrder = new ArrayList<>();
        postOrder.add(node2);
        postOrder.add(node3);
        postOrder.add(node1);

        List<BSTNode> inOrder = new ArrayList<>();
        inOrder.add(node2);
        inOrder.add(node1);
        inOrder.add(node3);

        BSTNode root = constructTree(inOrder, postOrder);
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
         int index;

         public Index(int index) {
             this.index = index;
         }
    }
}