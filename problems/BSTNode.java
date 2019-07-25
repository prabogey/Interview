public class BSTNode implements Comparable<BSTNode> {
    Integer val;
    BSTNode right;
    BSTNode left;

    public BSTNode(int x) {
        this.val = x;
    }

    @Override
    public int compareTo(BSTNode other) {
        return this.val.compareTo(other.val);
    }
}