public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        // 2D memo table
        if (s.length() == 0 || s.length() == 1) return s;
        int n  = s.length();
        boolean[][] table = new boolean[n][n];
        int maxLength = Integer.MIN_VALUE;
        int longestBegin = 0;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
            maxLength = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                longestBegin = i;
                maxLength = 2;
            } 
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    if (len > maxLength) {
                        maxLength = len;
                        longestBegin = i;
                    }
                }
            }
        }
        return s.substring(longestBegin, longestBegin + maxLength);
    }

    public static void main(String[] args) {
        String val = "abadd";
        System.out.println(longestPalindrome(val));
    }
}
