// returns tree if a given BST is valid or not

public class BSTValid {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        // if the root value is less than minimum or greater than max then it cannot be a valid BST 
        // because it violates the constraints
        if (root.val < min || root.val > max) {
            return false;
        }
        // when we recursively call this function we need to lower the constrats of one side beacuse
        // the left subtree needs to contain only values less than its root
        // the right subtree needs to contain only values greater than its root
        return (isValid(root.left, min, root.val-1) && isValid(root.right, root.val+1, max));
    }
}