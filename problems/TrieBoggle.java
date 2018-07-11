public class TrieBoggle {

    public boolean boogleSearch(char[][] board, String key) {
        if (!root.refs.containsKey(key.charAt(0))) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == key.charAt(0)) {
                    return boggleHelper(board, key.substring(1, key.length()), i, j, root.refs.get(key.charAt(0)));
                }
            }
        }
        return false;
    }

    private boolean isSafe(int x, int y, int height, int width) {
        return (x >= 0 && x < height && y >= 0 &&
                y < width);
    }

    private boolean boggleHelper(char[][] board, String key, int x, int y, TrieNode root) {
        int width = board.length;
        int height = board[0].length;
        if (root == null) return false;
        if (key.length() == 0) {
            return root.completeWord;
        }
        if (!root.refs.containsKey(key.charAt(0))) return false;

        // right one
        if (isSafe(x + 1, y, height, width) && board[x + 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x + 1, y, root.refs.get(key.charAt(0)));
        }

        //left one 
        if (isSafe(x - 1, y, height, width) && board[x - 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x - 1, y, root.refs.get(key.charAt(0)));
        }

        // up one
        if (isSafe(x, y - 1, height, width) && board[x][y - 1] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x, y - 1, root.refs.get(key.charAt(0)));
        }

        // down one
        if (isSafe(x, y + 1, height, width) && board[x][y + 1] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x - 1, y, root.refs.get(key.charAt(0)));
        }

        // diagonal up right
        if (isSafe(x + 1, y - 1, height, width) && board[x - 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x + 1, y - 1, root.refs.get(key.charAt(0)));
        }

        // diagonal down right
        if (isSafe(x + 1, y + 1, height, width) && board[x - 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x + 1, y + 1, root.refs.get(key.charAt(0)));
        }

        // diagonal up left
        if (isSafe(x - 1, y - 1, height, width) && board[x - 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x - 1, y - 1, root.refs.get(key.charAt(0)));
        }

        // diagonal down left
        if (isSafe(x - 1, y, height, width) && board[x - 1][y + 1] == key.charAt(0) && board[x - 1][y] == key.charAt(0)) {
            return boggleHelper(board, key.substring(1, key.length()), x - 1, y, root.refs.get(key.charAt(0)));
        }
        return false;
    }
}