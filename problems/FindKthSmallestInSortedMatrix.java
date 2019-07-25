import java.util.PriorityQueue;

public class FindKthSmallestInSortedMatrix {
    // you have a matrix with every row sorted and every column sorted
    // create a priority queue of all elements in first row
    // while i is less than k, remove an element from the priority queue and all the element below it
    // so when you add to a priority queue you need to save the jth index of that element
    // keep doing this k times and then you found the kth smallest element

    public int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<PQNode> pq = new PriorityQueue<>();
        for (int i = 0; i < matrix[0].length; i++) {
            PQNode node = new PQNode(0, i, matrix[0][i]);
            pq.add(node);
        }

        int i = 0;
        PQNode curr = null;
        while (i < k) {
            curr = pq.remove();
            if (isSafe(matrix, curr.i, curr.j + 1)) {
                PQNode node = new PQNode(curr.i, curr.j + 1, matrix[curr.i][curr.j]);
                pq.add(node);
            }
            i++;
        }
        if (curr == null) return -1;
        return curr.val;
    }

    public boolean isSafe(int[][] matrix, int i, int j) {
        return (i < matrix.length && j < matrix[0].length);
    }

}

class PQNode implements Comparable<PQNode> {
    int i;
    int j;
    Integer val;

    public PQNode(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public int compareTo(PQNode o) {
        return this.val.compareTo(o.val);
    }
}