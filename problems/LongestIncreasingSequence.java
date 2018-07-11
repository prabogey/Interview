public class LongestIncreasingSequence {
    // this method will find the longest path such that each subsequent node on this path is one greater in val that its parent
    public static int longestPathByOne(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(helper(root.left, root.val + 1, 0), helper(root.right, root.val + 1, 0));
        }
    }

    public static int helper(TreeNode root, int val, int count) {
        if (root == null) {
            return count;
        }
        if (root.val == val) {
            count += 1;
        } else {
            count = 1;
        }
        int left = helper(root.left, root.val + 1, count);
        int right = helper(root.right, root.val + 1, count);
        right = Math.max(right, count);
        return Math.max(left, right);
    }
}