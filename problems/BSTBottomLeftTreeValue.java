public class BSTBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        // find height of tree
        // use bfs recursion to get to this height
        // call the recursion on the left subtree before the right subtree
        // when you get to the level, return the node
        // if the left subtree recursive call resulted in null, call the function on the right subtree now
        // if it did not return null then return this node obtained from the right recursive call
        // the node has to either be in the right or left subtree
        
        int height = height(root);
        TreeNode curr = depthLimited(root, height);
        return curr.val;
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return (left > right) ? left + 1 : right + 1;
    }
    
    public TreeNode depthLimited(TreeNode root, int level) {
        if (root == null) return null;
        if (level == 1) return root;
        TreeNode left = depthLimited(root.left, level - 1);
        if (left != null) {
            return left; // we are doing this because we want to find the left most value
        }
        TreeNode right = depthLimited(root.right, level - 1);
        return right;
    }
}