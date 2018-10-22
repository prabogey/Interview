import java.util.*;

public class InorderByLevel {
    public static void solution(TreeNode root, int k) {
        Queue<TreeNode> next = new LinkedList<>();
        fill(root, next, k);
        print(root, k);
        while(!next.isEmpty()) {
            Queue<TreeNode> newNext = new LinkedList<>();
            while(!next.isEmpty()) {
                fill(nextCopy.remove(), newNext, k);
            }
            next = newNext;
        }
    }

    public static void fill(TreeNode root, Queue<TreeNode> next, int k) {
        if (root == null) return;
        if (k == 1) {
            if (root.left != null) next.add(root.left);
            if (root.right != null) next.add(root.right);
            System.out.println(root.val);
        } else {
            fill(root.left, next, k - 1);
            System.out.println(root.val);
            fill(root.right, next, k - 1);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v, TreeNode l, TreeNode r) {
        val = v;
        left = l;
        right = r;
    }
}

class BinaryTree {
    TreeNode root;
    
    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        TreeNode extra = new TreeNode(val, null, null);
        if (root == null) {
            root = extra;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode temp;
        while(!q.isEmpty()) {
            temp = q.remove();
            if (temp.left == null) {
                temp.left = extra;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = extra;
                break;
            } else {
                q.add(temp.right);
            }
        }
    }
}