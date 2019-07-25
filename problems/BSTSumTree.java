public class BSTSumTree {
	public static BSTNode findSumTree(BSTNode root) {
      if (root == null) return null;
      int left = helper(root.left);
      int right = helper(root.right);
      root.val = left + right + root.val;
      return root;
	}

  public static int helper(BSTNode root) {
      if (root == null) return 0;
      int left = helper(root.left);
      int right = helper(root.right);
      return root.val = left + right + root.val;
  }

  public static void main(String[] args) {
        BSTNode node1 = new BSTNode(1);
        BSTNode node3 = new BSTNode(3);
        BSTNode node4 = new BSTNode(5);
        BSTNode node2 = new BSTNode(2);
        node3.left = node1;
        node3.right = node5;
        node1.right = node2;
        
        System.out.println(findSumTree(node3).val);
  }
}
