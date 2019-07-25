import java.util.*;

// https://www.techiedelight.com/build-binary-tree-given-parent-array/
public class BTCreateFromParentArray {
    public static BSTNode create(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
            List<Integer> lis;
            if (map.containsKey(arr[i])) {
                lis = map.get(arr[i]);
            } else {
                lis = new LinkedList<>();
            }
            lis.add(i);
            map.put(arr[i], lis);
        }
        return helper(0, map);
    }

    public static BSTNode helper(Integer root, HashMap<Integer, List<Integer>> map) {
        BSTNode curr = new BSTNode(root);
        if (!map.containsKey(root)) return curr;
        List<Integer> children = map.get(root);
        if (children.size() == 0) return curr;
        curr.left = helper(children.get(0), map);
        if (children.size() == 2) {
            curr.right = helper(children.get(1), map);
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 0, 1, 2, 2, 4, 4};
        BSTNode root = create(arr);

        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        // 0, 1, 2, 3, 4, 5, 6, 7
        while (!q.isEmpty()) {
            BSTNode curr = q.remove();
            System.out.println(curr.val);
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}