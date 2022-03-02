public class EditDistance {
    public static int findEditDisnace(String m, String n) {
        int[][] table = new int[m.length() + 1][n.length() + 1];
        for (int i = 0; i <= m.length(); i++) {
            for (int j = 0; j <= n.length(); j++) {
                if (i == 0) {
                    table[i][j] = j; //if i == 0 then you just add the length of n to the end 
                } else if (j == 0) {
                    table[i][j] = i; //if j == 0 then you just add the length of m to the end
                } else if (m.charAt(i - 1) == n.charAt(i - 1)) { // if they are the same just ignore and continue
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = 1 + Math.min(Math.min(table[i - 1][j], table[i][j - 1]), table[i - 1][j - 1]);
                    // first is for removing a character, second is for inserting a chracter, and then third is for replacing a character
                }
            }
        }
        return table[m.length()][n.length()];
    }
}