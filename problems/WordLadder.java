import java.util.*;

class WordLadder {
    // this is a graph problem, BFS
    // each word in the list (including the start word is a vertex)
    // there is an edge between two words if their edit distance is one
    // want to find the shortest path from beginWord to endWord
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // edit distance code
        // edit distance between current word and word looking for in array has to be 1
        // if the edit distance between the words is 1 add it to a queue
        Queue<qTemp> q = new LinkedList<>();
        q.add(new qTemp(beginWord, 1));
        while(!q.isEmpty()) {
            qTemp curr = q.remove();
            // we are using an iterator so we can modify the original list
            Iterator<String> it = wordList.iterator();
            while (it.hasNext()) {
                String tmp = it.next();
                // if the edit distance between the two words is exactly 1, continue
                if (editDistance(curr.s, tmp)) {
                    // System.out.println(curr.s + ", " + tmp);
                    int len = curr.len + 1;
                    q.add(new qTemp(tmp, len));
                    // we have to remove from the iterator or we will get a ConcurrentModificationException
                    it.remove();
                    // removing it from list because we do not need to iterate over it again
                    wordList.remove(tmp);
                    // if the word has an edit distance of one and is the same as the end word, then simply return the length
                    if (tmp.equals(endWord)) {
                        return len;
                    }
                }
            }  
        }
        return 0;
    }
    
    private static boolean editDistance(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return (count == 1);
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        System.out.println(ladderLength("hit", "cog", words));
    }
}

class qTemp {
    int len;
    String s;

    public qTemp(String s, int len) {
        this.len = len;
        this.s = s;
    }
}