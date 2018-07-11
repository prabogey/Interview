
public class TicTacValid {
    public boolean winner(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            boolean down = dfsDown(board, 0, j);
            if (down) return down;
        }
        for (int i = 0; i < board[0].length; j++) {
            boolean down = dfsAcross(board, i, 0);
            if (down) return down;
        }
        boolean diag = diagDFSTopLeft(board, 0, 0);
        if (diag) return true;
        diag = diagDFSTopRight(board, 0, board[0].length - 1);
        if (diag) return true;
        return false;
    }

    public boolean dfsDown(char[][] board, int i, int j) {
        int height = board[0].length;
        char check = board[i][j];
        for (int row = i + 1; row < height; row++) {
            if (board[row][j] != check) {
                return false;
            }
        }
        return true;
    }
    public boolean dfsAcross(char[][] board, int i, int j) {
        int width = board.length;
        char check = board[i][j];
        for (int col = j + 1; col < width; col++) {
            if (board[i][col] != check) {
                return false;
            }
        }
        return true;
    }

    public boolean diagDFSTopLeft(char[][] board, int i, int j) {
        int width = board.length;
        int height = board[0].length;
        char check = board[i][j];
        i++;
        j++;
        while (i < height && j < width) {
            if (board[i][j] != check) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
    public boolean diagDFSTopRight(char[][] board, int i, int j) {
        int width = board.length;
        int height = board[0].length;
        char check = board[i][j];
        i++;
        j--;
        while (i < height && j >= 0) {
            if (board[i][j] != check) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}