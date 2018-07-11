import java.util.HashMap;

public class DuplicatesBST {
    // serialize the tree
    public static List<Integer> duplicateFinder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        HashMap<String, Integer> counts = new HashMap<>();
        String serial = serialize(root, ret, counts);
        return ret;
    }
    // returns a unique string representation of every possible subtree
    // recursively call this method
    // if 4 is a leaf node then this method will return 4,#,#
    // if 2 is the parent node of 4 and it has no right node
    // 2,4,#,#,# <- last # sign is for the right node of 2 node
    public static String serialize(TreeNode root, List<Integer> ret, HashMap<String, Integer> counts) {
        if (root == null) return "#";
        String left = serialize(root.left, ret, counts);
        String right = serialize(root.right, ret, counts);
        String serial = node.val + "," + left + "," + right;
        counts.put(serial, counts.getOrDefault(serial, 0) + 1);
        if (counts.get(serial)  == 2) {
            ret.add(node.val);
        }
        return serial;
    }

    // deserialize does not work    
    public static TreeNode deserialize(String s) {
        int i = 0;
        if (s.length() == 0) return null;
        TreeNode root = new TreeNode(s.charAt(i) - '0');
        i++;
        root.left(deserialize(s, i));
        root.right(deserialize(s, i));
        return root;
    }

    public static TreeNode deserialize(String s, int i) {
        if (s.charAt(i) == '#') {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(s.charAt(i) - '0');
        i++;
        root.left(deserialize(s, i));
        root.right(deserialize(s, i));
        return root; 
    }
}