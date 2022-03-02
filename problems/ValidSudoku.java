import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean colsAndRows = isValid(board);
        if (!colsAndRows) {
            return colsAndRows;
        }
        // System.out.println("grid");
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                boolean grid = checkGrid(board, i, j);
                if (!grid) {
                    return grid;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkGrid(char[][] board, int i, int j) {
        HashSet<Character> visited = new HashSet<>();
        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                if (board[row][col] != '.' && !visited.add(board[row][col])) {
                    return false;
                }
            }
        }
        return true;
    }
}