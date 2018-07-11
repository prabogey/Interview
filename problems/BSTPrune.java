public class BSTPrune {
    // this function returns a new tree such that each subtree in the new tree contains a 1 
    // if there is a tree centered at 0 and this node does not contain a 1 then it is removed from the tree
    public TreeNode pruneTree(TreeNode root) {
        // if root.val == 1, root.left = recurse on left
        // root.right = recurse on right
        // if root.val == 0, call helper function to check if that subtree contains a 1
        // if it does continue as before
        // if it does not return null
        if (root == null) return null;
        if (root.val == 1) {
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);
        } else {
            if (checker(root)) {
                root.left = pruneTree(root.left);
                root.right = pruneTree(root.right);
            } else {
                return null;
            }
        }
        return root;
    }
    
    // private method to check if tree at root has a 1 in it
    private boolean checker(TreeNode root) {
        if (root == null) return false;
        if (root.val == 1) {
            return true;
        }
        boolean left = checker(root.left);
        if (left) return true;
        boolean right = checker(root.right);
        if (right) return true;
        return false;
    }
}