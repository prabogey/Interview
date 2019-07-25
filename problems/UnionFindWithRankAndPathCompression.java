
public class UnionFindWithRankAndPathCompression {
    class UFNode {
        int rank;
        int parent;
    }
    // the idea here is to make Union Find log n worst case
    // so whenever you Union two nodes together, always attach the smaller rank to the larger rank
    // whenever you want to do a find on a node, always keep updating its parent to the top node

    // lets initialize our array as: [[0,0], [0,1], [0, 2], [0, 3], [0, 4]]
    // where the index is the val (so the 0th index has val 0)
    // and the array inside is rank, parent

    // This algorithm is recursively updating the parent of a node (path compression)
    public int find(UFNode[] disjoint, int x) {
        if (disjoint[x].parent != x) {
            disjoint[x].parent = find(disjoint, disjoint[x].parent);
        }
        return disjoint[x].parent;
    }

    public void union(UFNode[] disjoint, int x, int y) {
        int xParent = find(disjoint, x);
        int yParent = find(disjoint, y);
        if (xParent == yParent) return;

        if (disjoint[xParent].rank > disjoint[yParent].rank) {
            disjoint[yParent].parent = xParent;
            disjoint[xParent].rank++;
        } else if (disjoint[yParent].rank > disjoint[yParent].rank) {
            disjoint[xParent].parent = yParent;
            disjoint[yParent].rank++;
        } else {
            // ranks are equal
            disjoint[yParent].parent = xParent;
            disjoint[xParent].rank++;
        }
    }

}