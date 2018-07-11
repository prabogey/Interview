public class BSTTrim {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        // remove with pointer reinforcement if node.val is not within some bounds
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}