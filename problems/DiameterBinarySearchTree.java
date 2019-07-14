public class DiameterBinarySearchTree {
    int ans;
    public int findDiameter(BSTNode root) {
        ans = 0;
        findDepth(root);
        return ans;
    }

    private int findDepth(BSTNode root) {
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = findDepth(root.left);
        }
        if (root.right != null) {
            right = findDepth(root.right);
        }
        // we do this because the diameter is defined as the longest path between any two nodes
        // by adding left+right+1 we are essentially saying that the longest path through a node, r, is the depth of its right subtree
        // plus the depth of its left subtree
        ans = Math.max(ans, left + right);
        // we do left + right + 1 because in an empty 
        return Math.max(left, right) + 1;
    }
}