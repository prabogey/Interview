import java.util.*;
// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character but a character may map to itself.
// "aa" -> "ab" = false
// "egg" -> add = true
// "foo" -> bar = false

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> visited = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                if (!visited.contains(s.charAt(i))) {
                    map.put(t.charAt(i), s.charAt(i));
                    visited.add(s.charAt(i));
                } else {
                    return false;
                }
            } else {
                char c = map.get(t.charAt(i));
                if (c != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // storing the last seen index of the character in an array
    // if these two values are not equal then return false
    public boolean isIsomorphicLessSpace(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
}