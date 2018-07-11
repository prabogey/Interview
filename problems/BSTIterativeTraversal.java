public class BSTIterativeTraversal {
    public static List<Integer> iterativeInOrder(TreeNode root) {
        Stack<TreeNode> visited = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        visited.push(root);
        TreeNode curr = root;
        while (!visited.isEmpty()) {
            while(curr.left != null) {
                visited.push(curr.left);
                curr = curr.left;
            }
            TreeNode pop = visited.pop();
            ret.add(pop.val);         
            if (pop.right != null) {
                visited.push(pop.right);
                curr = visited.peek();
            }
        }
        return ret;
    }

    public static List<Integer> iterativePreOrder(TreeNode root) {
        Stack<TreeNode> visited = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        visited.push(root);
        while (!visited.isEmpty()) {
            TreeNode pop = visited.pop();
            ret.add(pop.val);
            if (pop.right != null) {
                visited.push(pop.right);
            }
            if (pop.left != null) {
                visited.push(pop.left);
            }
        }
        return ret;
    }
}