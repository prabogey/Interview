public class BSTMaxWidth {
    public int maxWidth(TreeNode root) {
        int max = 0;
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            int width = getMaxWidth(root, i);
            if (width > max) {
                max = width;
            }
        }
        return max;
    }

    public int getMaxWidth(TreeNode root, int level) {
        if (root == null) return 0;
        if (level == 1) return 1;
        return getMaxWidth(root.left, level - 1) + getMaxWidth(root.right, level - 1);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        int ret = Math.max(left, right);
        return ret + 1;
    }
}