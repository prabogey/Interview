public class BSTFindTilt {
    // tilt is defined as absolute value of left subtree - right subtree
    // find total tilt in the tree
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        List<Integer> tilts = new LinkedList<>();
        findTilt(root, tilts);
        int total = 0;
        for (Integer x: tilts) {
            total += x;
        }
        return total;
    }
    
    public int findTilt(TreeNode root, List<Integer> tilts) {
        if (root == null) return 0;
        int left = findTilt(root.left, tilts);
        int right = findTilt(root.right, tilts);
        tilts.add(Math.abs(left - right));
        return root.val + left + right;
    }
}