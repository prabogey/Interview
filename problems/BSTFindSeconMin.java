public class BSTFindSecondMin {
    public int findSecondMinimumValue(TreeNode root) {
        // store all unique values in a set
        // use dfs to find all values
        // the root has the smallest value in its subtree
        // ie. main root is smallest value in tree
        if (root == null) return -1;
        HashSet<Integer> visited = new HashSet<>();
        int min = root.val;
        int ans = Integer.MAX_VALUE;
        dfs(root, visited);
        for (Integer x: visited) {
            if (min < x && x < ans) {
                ans = x;
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
    
    public void dfs(TreeNode root, HashSet<Integer> vis) {
        if (root != null) {
            vis.add(root.val);
            dfs(root.left, vis);
            dfs(root.right, vis);
        }
    }
}