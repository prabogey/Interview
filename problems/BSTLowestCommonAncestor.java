public class BSTLowestCommonAncestor {
    // works on Binary Tree or Binary Search Trees
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (right != null && left != null) {
            return root;
        }
        return (left != null) ? left : right;
    }
}