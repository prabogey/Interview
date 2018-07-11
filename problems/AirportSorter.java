import java.util.*;

public class AirportSorter {
    public static ArrayList<String[]> sort(String[][] airports) {
        HashMap<String, String[]> map = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        ArrayList<String[]> ordered = new ArrayList<>();
        for (int i = 0; i < airports.length; i++) {
            map.put(airports[i][0], airports[i]);
            visited.add(airports[i][1]);
        }
        Set<String> keySet = new HashSet<>(map.keySet());
        keySet.removeAll(visited);
        String key = "";
        for (String port: keySet) {
            key = port;
        }
        int i = 0;
        while (i < map.keySet().size() && map.get(key) != null) {
            String[] tuple = map.get(key);
            ordered.add(tuple);
            key = tuple[1];
            i++;
        }
        return ordered;
    }

    public static void main(String[] args) {
        String[][] ports = {
            {"ITO", "KOA"},
            {"ANC", "SEA"},
            {"LGA", "CDG"},
            {"KOA", "LGA"},
            {"PDX", "ITO"},
            {"SEA", "PDX"}
        };
        ArrayList<String[]> returned = sort(ports);
        for (String[] ret: returned) {
            System.out.println(ret[0] + " " + ret[1]);
        }
    }
}