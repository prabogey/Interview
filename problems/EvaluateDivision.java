// https://leetcode.com/problems/evaluate-division/

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // create a graph
        // have a set of nodes
        // edge weights are the answers
        // if node does not exist in set then its -1
        // if there is no path from query[0] to query[1] then -1
        // node to node is edge weight 1
        
        // building graph here
        HashMap<String, HashMap<String, Double>> adj = new HashMap<>();
        int i = 0;
        for (List<String> str : equations) {
            String src = str.get(0);
            String dest = str.get(1);
            double val = values[i];
            if (adj.containsKey(src)) {
                HashMap<String, Double> next = adj.get(src);
                next.put(dest, val);
                adj.put(src, next);
            } else {
                HashMap<String, Double> next = new HashMap<>();
                next.put(dest, val);
                next.put(src, 1.0);
                adj.put(src, next);
            }
            if (adj.containsKey(dest)) {
                HashMap<String, Double> next = adj.get(dest);
                next.put(src, 1/val);
                adj.put(dest, next);
            } else {
                HashMap<String, Double> next = new HashMap<>();
                next.put(src, 1/val);
                next.put(dest, 1.0);
                adj.put(dest, next);
            }
            i++;
        }
        
        // do dfs on this graph
        double[] ret = new double[queries.size()];
        i = 0;
        for (List<String> query : queries) {
            ret[i] = processQuery(query, adj);
            i++;
        }
        return ret;
    }
    
    public double processQuery(List<String> query, HashMap<String, HashMap<String, Double>> adj) {
        String src = query.get(0);
        String dest = query.get(1);
        Set<String> visited = new HashSet<>();
        return dfs(src, dest, adj, visited);
    }
    
    public double dfs(String src, String dest, HashMap<String, HashMap<String, Double>> adj, Set<String> visited) {
        if (!adj.containsKey(src)) return -1.0;
        HashMap<String, Double> next = adj.get(src);
        if (next.containsKey(dest)) return next.get(dest);
        visited.add(src);
        for (String inter : next.keySet()) {
            if (visited.contains(inter)) continue;
            double currVal = next.get(inter);
            double val = dfs(inter, dest, adj, visited);
            if (currVal * val > 0) {
                return currVal * val;
            }
        }
        return -1;
    }
}