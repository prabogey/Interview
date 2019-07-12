// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

// Example:
// Input: 
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Output: 4

public class MaximalSquare {
    // The intuition behind this is that imagine the place in the matrix you are at is the bottom right of a square
    // if above, to the left, and diagonaly up to the left are all squares
    // then this is a square also
    // keep a running count of the 1s above and to the left
    // if you are at a 0, then the count resets and the value in the memo-table is a 0
    // utilize Math.min to ensure you always take the lowest number to create the square
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if (matrix.length == 0) return ans;
        if (matrix[0].length == 0) return ans;
        int[][] result = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    result[i][j] = Math.min(Math.min(result[i - 1][j], result[i][j - 1]), result[i - 1][j - 1]) + 1;
                    ans = Math.max(ans, result[i][j]);
                }
            }
        }
        return ans * ans;
    }
}