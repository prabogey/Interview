public class BSTSymmetric {
    // the logic behind this is that for a tree to be symmetric, their two roots have to have the same val
    // and their left and right subtrees need to be crossed
    // think about a person looking into a mirror
    // your left arm is on the right side in the mirror and vice versa
    // think about this as the left and right subtrees of the tree
    // if both nodes passed in are null then the previous nodes were leaf nodes, and they have no arms
    // if one node is not null then, essentially one arm is bigger than the other, and they are not symmetric
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t, TreeNode s) {
        if (t == null && s == null) return true;
        if (t == null || s == null) return false;
        return ( (t.val == s.val) && isMirror(t.left, s.right) && isMirror(t.right, s.left));
    }
}