import java.util.*;

// P: ABABAAB
// Q: AAB
// find the minimum number of different in order subsequences of Q you need to make P

public class MattGoogleStringSubstring {
    public static int findMinNumberOfQ(String p, String q) {
        HashMap<Character, List<Integer>> qEnum = new HashMap<>();
        Stack<String> cache = new Stack<>();
        cache.add(q);
        for (int i = 0; i < q.length(); i++) {
           List<Integer> lis;
           if (qEnum.containsKey(q.charAt(i))) {
               lis = qEnum.get(q.charAt(i));
           } else {
               lis = new LinkedList<>();
           }
           lis.add(i);
           qEnum.put(q.charAt(i), lis);
        }

        Index tracker = new Index(0);
        int total = 0;
        while(tracker.val < p.length()) {
            helper(p, tracker, qEnum, cache);
            total++;
        }
        return total;
    }

    public static void helper(String p, Index tracker,  HashMap<Character, List<Integer>> qEnum, Stack<String> cache) {
        if (cache.contains(p.substring(tracker.val))) {
            tracker.val = p.length();
            return;
        }
        int start = tracker.val;
        int curr = -1;
        while (tracker.val < p.length()) {
            List<Integer> index = qEnum.get(p.charAt(tracker.val));
            int found = -1;
            for (Integer x : index) {
                if (x > curr && found == -1) {
                    found = x;
                }
            }
            if (found == -1) {
                break;
            }
            curr = found;
            tracker.val = ++tracker.val;
        }
        cache.add(p.substring(start, tracker.val));
        return;
    }

    static class Index {
        int val;

        public Index(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        String p = "ABABAAB";
        String q = "AABC";

        // should print 3;
        System.out.println(findMinNumberOfQ(p, q));
    }
}