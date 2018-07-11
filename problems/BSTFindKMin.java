public class BSTFindKMin {
    // First method uses a PQ, this is better for when the BST is edited a lot and it gives O(N log N) complexity
    public int kthSmallest(TreeNode root, int k) {
        // Priority Queue
        PriorityQueue<Integer> ret = new PriorityQueue<>();
        dfs(root, ret);
        int i = 0;
        int val = 0;
        while (i < k) {
            val = ret.remove();
            i++;
        }
        return val;
    }
    
    public void dfs(TreeNode root, PriorityQueue<Integer> ret) {
        if (root != null) {
            ret.add(root.val);
            dfs(root.left, ret);
            dfs(root.right, ret);
        }
    }

    // This method is like binary search on the BST
    // since you know all elements less than the current will be on the left subtree and all elements greater will be on the right subtree
    // then you can simply count how many nodes there on the left subtree, if there are more nodes than the value of k, you know the answer
    // has to lie in the left subtree
    // if k is greater than this value then you know that the answer has to be in the right subtree
    public int findKMinBinarySearch(TreeNode root, int k) {
        int left = count(root.left);
        if (k <= count) {
            return findKMinBinarySearch(root.left, k);
        } else if (k > count + 1) {
            return findKMinBinarySearch(root.right, k - 1 - count); // we have to subtract one (because the root counts) and we subtract
            // count because we dont care about the entire left subtree which contains count number of lower nodes
        }

        return root.val; // we have found it when k == count + 1;
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}