public class BinaryTreeAverageLevel {
    // finds the average of each level in a binary tree and adds it to a list
    // O(n) time and O(n) extra space
    // doing level order this way is good, it is the recursive BFS way of doing it
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            ArrayList<Integer> visited = new ArrayList<>();
            averageLevel(root, i, visited);
            long sum = 0;
            for (Integer x: visited) {
                sum += x;
            }
            double average = ((double) sum)/visited.size();
            ret.add(average);
        }
        return ret;
    }
    
    public void averageLevel(TreeNode root, int level, ArrayList<Integer> visited) {
        if (root == null) return;
        if (level == 1) {
            visited.add(root.val);
            return;
        }
        averageLevel(root.left, level - 1, visited);
        averageLevel(root.right, level - 1, visited);
        return;
    } 
    
    public int height(TreeNode node) 
    {
        if (node == null) 
            return 0;
        else
        {
              
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight) 
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    // two queue BFS approach
    // one queue is for your current level
    // add all of the current levels children nodes to the 2nd queue
    // after iterating through the original queue (it is empty)
    // set queue = temp
    public List < Double > averageOfLevelsTwoQ(TreeNode root) {
        List < Double > res = new ArrayList < > ();
        Queue < TreeNode > queue = new LinkedList < > ();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode n = queue.remove();
                sum += n.val;
                count++;
                if (n.left != null)
                    temp.add(n.left);
                if (n.right != null)
                    temp.add(n.right);
            }
            queue = temp;
            res.add(sum * 1.0 / count);
        }
        return res;
    }
}