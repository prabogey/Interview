public class BSTLargestValue {
    // returns a list of the largest values in each level
    // one queue keeps track of current level
    // add to second queue which contains all nodes in second level
    public List<Integer> largestValues(TreeNode root) {
        // 2 Q implementation
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> orig = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        orig.add(root);
        while (!orig.isEmpty()) {
            Queue<TreeNode> second = new LinkedList<>();
            int max = Integer.MIN_VALUE;
            while (!orig.isEmpty()) {
                TreeNode curr = orig.remove();
                if (curr.val > max) max = curr.val;
                if (curr.left != null) second.add(curr.left);
                if (curr.right != null) second.add(curr.right);
            }
            ret.add(max);
            orig = second;
        }
        return ret;
    }
}