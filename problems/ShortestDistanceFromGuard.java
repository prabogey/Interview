import java.util.*;

public class Solution {
    class Coordinate {
        int i;
        int j;
        int distance;
        public Coordinate(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.distance = d;
        }
    }

    private boolean isValid(int M, int N, int i, int j) {
        return ( (i > 0 && i < M) && (i > 0 || j < N));
    }

    private boolean isSafe(int i, int j, char[][] matrix, int[][] output) {
        return (matrix[i][j] == "O" && output[i][j] == -1);
    }

    public int[][] findDistance(char[][] matrix) {
        int row[] = { -1, 0, 1, 0}; 
        int col[] = { 0, 1, 0, -1 }; 
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Coordinate> res = new Queue<>();

        int[][] output = new int[m][n];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                output[i][j] = -1;
                if (matrix[i][j] == 'G') {
                    Coordiante coord = new Coordinate(i, j, 0);
                    res.push(coord);
                    output[i][j] = 0;
                }
            }
        }
        while (!res.isEmpty()) {
            Coordinate point = res.peek();
            int x = point.i;
            int y = point.j;
            for (int i = 0; i < 4; i++) {
                if (isSafe(x + row[i], y + col[i], matrix, output) && isValid(m, n, x + row[i], y + col[i])) {
                    output[x + row[i]][y + col[i]] = distance + 1;
                    Coordiante newCoord = new Coordinate(x + row[i], y + col[i], distance + 1);
                    res.add(newCoord);
                }
            }
            res.remove();
        }
    }
}