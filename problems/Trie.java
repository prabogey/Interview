import java.util.*;

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        int n = key.length();
        TrieNode curr = root;
        for (int i = 0; i < n; i++) {
            if(!curr.refs.containsKey(key.charAt(i))) {
                curr.refs.put(key.charAt(i), new TrieNode());
            }
            curr = curr.refs.get(key.charAt(i));
        }
        curr.completeWord = true;
    }

    public boolean search(String key) {
        int n = key.length();
        TrieNode curr = root;
        for (int i = 0; i < n; i++) {
            if (!curr.refs.containsKey(key.charAt(i))) {
                return false;
            }
            curr = curr.refs.get(key.charAt(i));
        }
        return curr.completeWord;
    }

    public boolean searchPrefix(String key) {
        int n = key.length();
        TrieNode curr = root;
        for (int i = 0; i < n; i++) {
            if (!curr.refs.containsKey(key.charAt(i))) {
                return false;
            }
            curr = curr.refs.get(key.charAt(i));
        }
        return true;
    }

    // method returns the longest prefix that is present (as a completed word) in the Trie
    // For example if child is the key and children is in the Trie
    // it will return an empty String since there is no word in this Trie dictionary that is also a prefix of child
    // however, if chil was in the Trie than it would return chil
    public String longestPrefix(String key) {
        StringBuilder ret = new StringBuilder("");
        TrieNode curr = root;
        int i = 0;
        while (curr.refs.size() > 0 && i < key.length()) {
            if (curr.refs.containsKey(key.charAt(i))) {
                ret.append(key.charAt(i));
                curr = curr.refs.get(key.charAt(i));
                i++;
            } else {
                // System.out.println(key.charAt(i));
                return ret.toString();
            }
        }
        if (i == key.length() && curr.completeWord == false) {
            return "";
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Trie prefix = new Trie();
        prefix.insert("are");
        prefix.insert("area");
        prefix.insert("base");
        prefix.insert("cat");
        prefix.insert("cater");
        prefix.insert("basement");
        prefix.insert("children");

        // System.out.println(prefix.longestPrefix("baseball"));


        // System.out.println(prefix.search("baseball"));
        // System.out.println(prefix.searchPrefix("ABCD"));

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));                      
 
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));                      
 
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));

        input = "child";
        System.out.print(input + ":   ");
        System.out.println(prefix.longestPrefix(input));

        
    }
}

class TrieNode {
    HashMap<Character, TrieNode> refs;
    boolean completeWord;

    public TrieNode() {
        completeWord = false;
        refs = new HashMap<>();
    }

    @Override
    public String toString() {
        return refs.toString();
    }
}