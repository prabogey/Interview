import java.util.*;
// https://www.geeksforgeeks.org/bridge-in-a-graph/

// The idea here is to have a time variable to tells you what time you discovered a certain node
// when you get to a certain NODE in DFS if you have not visited it, recurse on it to find out its lowest time
// lowest time is defined as the node with the earliest discovert time that you can use to get to your current node
// ie. from all the nodes adjacent to it what is the value of the lowest node that are adjacent to it and so on
// this algorithm basically checks to see how many vertices are you connected to that we have already discovered
// if you are only connected to one previous vertex then there is a bridge

public class FindBridgesInGraph {
    public static void findBridges(HashMap<Integer, List<Integer>> adj, int start) {
        HashMap<Integer, Integer> discovery = new HashMap<>();
        HashMap<Integer, Integer> lowest = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        int time = 0;
        findBridges(start, adj, discovery, lowest, visited, time);
    }

    public static void findBridges(int start, 
        HashMap<Integer, List<Integer>> adj, 
        HashMap<Integer, Integer> discovery, 
        HashMap<Integer, Integer> lowest, 
        HashMap<Integer, Integer> parent, 
        HashSet<Integer> visited, 
        int time) {
        visited.add(start);
        discovery.put(start, time);
        lowest.put(start, time);

        List<Integer> next = adj.get(start);
        for (Integer child : next) {
            if (!visited.contains(child)) {
                parent.put(child, start);
                findBridges(child, adj, discovery, lowest, parent, visited, time + 1);

                lowest.put(start, Math.min(lowest.get(start), lowest.get(child)));

                if (lowest.get(child) > discovery.get(start)) {
                    System.out.println("Bridge between: " + start + " and " + child);
                }
            } else if (parent.get(child) != start) {
                lowest.put(start, Math.min(lowest.get(start), lowest.get(child)));
            }
        }
        return;
    }
}