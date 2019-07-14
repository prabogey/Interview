// https://www.techiedelight.com/find-next-node-in-same-level-binary-tree/
import java.util.*;

public class BSTFindNextNodeInLevel {
    public static BSTNode findNextNode(BSTNode root, BSTNode target) {
        if (target == root) return null;

        // two queues one for previous level
        // one for level currently expanding
        Queue<BSTNode> curr = new LinkedList<>();
        curr.add(root);
        boolean found = false;
        while (!curr.isEmpty()) {
            Queue<BSTNode> temp = new LinkedList<>();
            while (!curr.isEmpty()) {
                BSTNode currNode = curr.remove();
                if (found) return currNode;
                if (currNode == target) found = true;
                if (currNode.left != null) temp.add(currNode.left);
                if (currNode.right != null) temp.add(currNode.right);
            }
            if (found) return null; // we found it in the level we just explored, but could not find the next node
            curr = temp;
        }
        return null;
    }

    public static void main(String[] args) {
        BSTNode node1 = new BSTNode(1);
        BSTNode node3 = new BSTNode(3);
        BSTNode node5 = new BSTNode(5);
        BSTNode node2 = new BSTNode(2);
        node3.left = node1;
        node3.right = node5;
        node1.right = node2;

        System.out.println(findNextNode(node3, node1).val); // should print 5
        System.out.println(findNextNode(node3, node2)); // should print null
    }
}