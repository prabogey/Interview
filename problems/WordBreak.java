import java.util.*;

public class WordBreak {
    // This is a dynamic programming problem
    // 3.7/5.0 Difficulty

    public static boolean wordBreak(String s, String[] dict) {
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            words.add(dict[i]);
        }

        boolean[] memo = new boolean[s.size() + 1];
        for (int i = 1; i <= s.size(); i++) {
            if (memo[i] == false && words.contains(s.substring(0, i))) {
                memo[i] = true;
            }
            if (memo[i] == true) {
                // we have reached the last index
                if (i == s.size()) {
                    return true;
                }
                for (int j = i + 1; j <= size; j++) {
                    if (memo[j] == false && words.contains(s.substring(i, j - i))) {
                        memo[j] = true;
                    }
                    if (memo[j] == true && j == size) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}