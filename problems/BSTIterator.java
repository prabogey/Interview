public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current;

    public BSTIterator(TreeNode root) {
        stack.push(root);
        current = root;
        while(current.left != null) {
            stack.push(current.left);
            current = current.left;
        }
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    TreeNode next() {
        TreeNode ret = stack.pop();
        if (ret.right != null) {
            stack.push(ret.right);
            current = ret;
        }
        return ret;
    }
}