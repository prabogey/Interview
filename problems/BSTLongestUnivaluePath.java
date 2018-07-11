public class BSTLongestUnivaluePath {
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return len;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        len = Math.max(len, left + right);
        return len;
    }
    
    private int helper(TreeNode root, int val) {
        if (root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        len = Math.max(len, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        } else {
            return 0;
        }
    }
}