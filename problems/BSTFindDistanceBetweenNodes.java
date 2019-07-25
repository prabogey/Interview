import java.util.*;

public class BSTFindDistanceBetweenNodes {
    // the intuition here is that we want to find the lowest commen ancestor of the nodes
    // when we find that simply compute the distance from both nodes to the lowest common ancestor and add them
    public int findDistance(BSTNode root, BSTNode startNode, BSTNode endNode) {
        BSTNode lca = findLCA(root, startNode, endNode);
        if (lca == null) return -1;
        return distance(lca, startNode) + distance(lca, endNode);
    }

    public BSTNode findLCA(BSTNode root, BSTNode p, BSTNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        BSTNode left = findLCA(root.left, p, q);
        BSTNode right = findLCA(root.right, p, q);
        if (right != null && left != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    public int distance(BSTNode root, BSTNode curr) {
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        int distance = 0;
        while (!q.isEmpty()) {
            Queue<BSTNode> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                BSTNode expand = q.remove();
                if (expand == curr) return distance;
                temp.add(expand.left);
                temp.add(expand.right);
            }
            distance++;
            q = temp;
        }
        return -1;
    }
}