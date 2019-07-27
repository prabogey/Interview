import java.util.*;
// Classic problem, find a way to put n-queens on an nxn chessboard

public class NQueens {
    public static void findNQueens(int n) {
        int[][] board = new int[n][n];

        HashSet<Integer> leftDiagonal = new HashSet<>();
        HashSet<Integer> up = new HashSet<>();
        HashSet<Integer> rightDiagonal = new HashSet<>();

        for (int i = 0; i < n; i++) {
            board[0][i] = 1;
            if (i + 1  != n) leftDiagonal.add(-i);
            up.add(i);
            if (i != 0) rightDiagonal.add(i);
            if (helper(board, 1, leftDiagonal, up, rightDiagonal)) return;
            leftDiagonal.remove(-i);
            up.remove(i);
            rightDiagonal.remove(i);
            board[0][i] = 0;
        }
    }

    public static boolean helper(int[][] board, int row, HashSet<Integer> leftDiagonal, HashSet<Integer> up, HashSet<Integer> rightDiagonal) {
        for (int i = 0; i < board[row].length; i++) {
            if (canPlace(row, i, leftDiagonal, up, rightDiagonal)) {
                board[row][i] = 1;
                if (row + 1 >= board.length) {
                    printBoard(board);
                    return true;
                }
                leftDiagonal.add(row - i);
                up.add(i);
                rightDiagonal.add(row + i);
                if (helper(board, row + 1, leftDiagonal, up, rightDiagonal)) return true;
                leftDiagonal.remove(row - i);
                up.remove(i);
                rightDiagonal.remove(row + i);
                board[row][i] = 0;
            }
        }
        return false;
    }

    public static boolean canPlace(int row, int col, HashSet<Integer> leftDiagonal, HashSet<Integer> up, HashSet<Integer> rightDiagonal) {
        // if (col == 2) {
        //     System.out.println("Row: " + row + " Col: " + col);
        //     System.out.println(row - col);
        //     System.out.println();
        // }
        return !up.contains(col) && !leftDiagonal.contains(row - col) && !rightDiagonal.contains(row + col);
    }

    public static void printBoard(int[][] board) {
        for (int[] x : board) {
            for (int y : x) {
                System.out.print(y + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        findNQueens(4);
    }
}