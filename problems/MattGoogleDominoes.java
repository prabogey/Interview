import java.util.*;

// find the longest path of dominoes
// dominoes can be connected if one of the values on the next dominoe is the same as one of the values on the current dominoe
// for this problem im assuming that we are passed a matrix of 2D arrays

public class MattGoogleDominoes {
    public int findLongestPath(int[][] dominoes) {
        // building the adj list
        HashMap<Integer, HashMap<Integer, Integer>> adj = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] curr = dominoes[i];
            if (adj.containsKey(curr[0])) {
                HashMap<Integer, Integer> next = adj.get(curr[0]);
                next.put(curr[0], next.getOrDefault(curr[1], 0) + 1);
                adj.put(curr[0], next);
            } else {
                HashMap<Integer, Integer> next = new HashMap<>();
                next.put(curr[0], next.getOrDefault(curr[1], 0) + 1);
                adj.put(curr[0], next);
            }

            if (adj.containsKey(curr[1])) {
                HashMap<Integer, Integer> next = adj.get(curr[1]);
                next.put(curr[1], next.getOrDefault(curr[0], 0) + 1);
                adj.put(curr[1], next);
            } else {
                HashMap<Integer, Integer> next = new HashMap<>();
                next.put(curr[1], next.getOrDefault(curr[0], 0) + 1);
                adj.put(curr[1], next);
            }
        }

        // The adjacency is now built. Start at any node and then go to the next one
        int len = 0;
        for (Integer start : adj.keySet()) {
            // we are starting at a certain node
            HashMap<Integer, Integer> next = adj.get(start);
            for (Integer key : next.keySet()) {
                // when you go to a node you want to decrement the counter
                // so you are not stuck in a loop as you keep going
                // after you are done finding the max path at a certain node you can increment it back
                next.put(key, next.get(key) - 1);
                updateKeyMap(key, start, adj, true);
                len = Math.max(len, traversePath(key, len, adj));
                updateKeyMap(key, start, adj, false);
                next.put(key, next.get(key) + 1);
            }
        }

        return len;
    }

    public static int traversePath(int start, int len, HashMap<Integer, HashMap<Integer, Integer>> adj) {
        HashMap<Integer, Integer> next = adj.get(start);
        len++;
        for (Integer key : next.keySet()) {
            if (next.get(key) > 0) {
                next.put(key, next.get(key) - 1);
                updateKeyMap(key, start, adj, true);
                len = Math.max(len, traversePath(key, len, adj));
                updateKeyMap(key, start, adj, false);
                next.put(key, next.get(key) + 1);
            }
        }
        return len;
    }

    public static void updateKeyMap(int key, int start, HashMap<Integer, HashMap<Integer, Integer>> adj, boolean remove) {
        HashMap<Integer, Integer> next = adj.get(key);
        if (remove) {
            next.put(start, next.get(start) - 1);
        } else {
            next.put(start, next.get(start) + 1);
        }
    }
}