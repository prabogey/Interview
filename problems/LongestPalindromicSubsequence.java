public class LongestPalindromicSubsequence {
    public int findLongest(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int n  = s.length();
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = 1;
        }
        // building the table diagonally
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        table[i][j] = 2;
                    } else {
                        table[i][j] = table[i + 1][j - 1] + 2;
                    }
                } else {
                    table[i][j] = Math.max(table[i + 1][j], table[i][j - 1]);
                }
            }
        }
        return table[0][n - 1];
    }
}

// The table is done with differing widths
// at first you just fill the diagonal
// then i = 0 and j = i + 1
// then i = 0 and j = i + 2
// and so on
// the result will be stored in the top right of the memo table