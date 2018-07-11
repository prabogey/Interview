public class LowestCommonAncestor {
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

    // only for binary search trees
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }
         if (p.val >= root.val && q.val <= root.val) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}