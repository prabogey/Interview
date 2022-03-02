public class LeetCodeSubstring {
    
    // purpsoe of this method is to find the length of the longest substring such that no characters are repeated

    // sliding window approach
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        HashSet<Character> visited = new HashSet<>();
        int ans = -1;
        while (i < n && j < n) {
            if (!visited.contains(s.charAt(j))) {
                visited.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                visited.remove(s.charAt(i));
                i++;
            }
            
        }
        return ans;
    }

    //optimized sliding window approach (with HashMap)
    public int lengthOptimized(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int i = 0;
        HashMap<Character, Integer> visited = new HashMap<>();
        int ans = -1;
        for (int j = 0; j < n; j++) {
            if (visited.containsKey(s.charAt(j))) {
                i = Math.max(visited.get(s.charAt(j)), i); // jump i to the index where the duplicate is, everything before this index
                // is not included in the substring
            }   
            visited.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}

