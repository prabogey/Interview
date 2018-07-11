import java.util.ArrayList;
import java.util.HashMap;

public class Anagrams {
    // check if t is a valid anagram of s
    // anagram means that strings contain the same number of an same characters
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> visited = new HashMap<>();
        for (char c: s.toCharArray()) {
            int put = visited.getOrDefault(c, 0) + 1;
            visited.put(c, put);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!visited.containsKey(t.charAt(i)) || visited.get(t.charAt(i)) == 0) {
                return false;
            }
            int put = visited.get(t.charAt(i)) - 1;
            visited.put(t.charAt(i), put);
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] list) {
        // this function is going to group all anagrams together
        // an anagram means that each word contains the same letters and number of letters as another
        // sort each word, all anagrams will have the same sort
        if (list == null) return null;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String word = list[i];
            char[] sorted = Arrays.sort(word.toCharArray());
            String key = String.valueOf(sorted);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(word);
        }
        return new ArrayList(map.values());
    }

    public List<Integer> findAllAnagrams(String s, String p) {
        // sliding window
        // update hashmap from begin
        // you know that if counter == 0 and j - i = p.length() then there is an anagram that begins at i
        List<Integer> ret = new ArrayList<>();
        if (p.length() > s.length()) return ret;
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            counts.put(p.charAt(i), counts.getOrDefault(p.charAt(i), 0) + 1);
        }
        int counter = counts.size();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (counts.containsKey(s.charAt(j))) {
                counts.put(s.charAt(j), counts.get(s.charAt(j)) - 1);
                if (counts.get(s.charAt(j)) == 0) counter--;
            }
            j++;
            while (counter == 0) {
                if (counts.containsKey(s.charAt(i))) {
                    counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
                    if (counts.get(s.charAt(i)) > 0) {
                        counter++;
                    }
                }
                if ((j - i) == p.length()) {
                    ret.add(i);
                }
                i++;
            }
        }
        return ret;
    }
}