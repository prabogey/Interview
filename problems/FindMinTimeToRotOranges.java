import java.util.*;
// https://www.geeksforgeeks.org/minimum-time-required-to-rot-all-oranges-dynamic-programming/
public class FindMinTimeToRotOranges {
    public static void findMinTimeToRotOranges(int[][] oranges) {
        // if its 0 then its empty 
        // if its 2 then its rotten
        // if its 1 then its a regular orange
        int[][] distance = new int[oranges.length][oranges[0].length];
        boolean[][] visited = new boolean[oranges.length][oranges[0].length];
        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 2) {
                    distance[i][j] = 0;
                } else if (oranges[i][j] == 0) {
                    distance[i][j] = Integer.MAX_VALUE;
                } else {
                    findDistance(i, j, oranges, distance, visited);
                }
            }
        }
        findMax(oranges, distance);
    }

    private static int findDistance(int i, int j, int[][] oranges, int[][] distance, boolean[][] visited) {
        if (i >= oranges.length || j >= oranges[0].length || j < 0 || i < 0) {
            return Integer.MAX_VALUE;
        }

        if (oranges[i][j] == 2) {
            distance[i][j] = 0;
            return 0;
        }

        if (oranges[i][j] == 0) {
            distance[i][j] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }

        // if we have visited a node and its value has already been set
        if (visited[i][j] && distance[i][j] > 0 && distance[i][j] < Integer.MAX_VALUE) {
            return distance[i][j];
        }

        // we have visited a node but not set its value, return to avoid infinite loops
        if (visited[i][j]) {
            return Integer.MAX_VALUE;
        }

        visited[i][j] = true;
        int left = findDistance(i, j - 1, oranges, distance, visited);
        int right = findDistance(i, j + 1, oranges, distance, visited);
        int up = findDistance(i - 1 , j, oranges, distance, visited);
        int down = findDistance(i + 1, j, oranges, distance, visited);

        int min = Math.min(left, Math.min(right, Math.min(up, down)));

        if (min == Integer.MAX_VALUE) {
            distance[i][j] = Integer.MAX_VALUE;
        } else {
            distance[i][j] = 1 + min;
        }
        visited[i][j] = false;

        return distance[i][j];
    }

    private static void findMax(int[][] oranges, int[][] distance) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < oranges.length; i++) {
            for (int j = 0; j < oranges[0].length; j++) {
                if (oranges[i][j] == 1 && distance[i][j] > max) {
                    max = distance[i][j];
                }
            }
        }
        if (max == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(max);
    }

    public static void main(String[] args) {
        int[][] oranges = 
        {{2, 1, 0, 2, 1},
        {0, 0, 1, 2, 1},
        {1, 0, 0, 2, 1}};

            findMinTimeToRotOranges(oranges);
    }
}