public class BSTSumOfLeftLeaves {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return ans;
        helper(root.left, true);
        helper(root.right, false);
        return ans;
    }
    
    public void helper(TreeNode root, boolean left) {
        if (root == null) return;
        if (left && root.left == null && root.right == null) {
            ans += root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
        return;
    }
}