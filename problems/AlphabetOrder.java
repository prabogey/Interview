import java.util.*;

public class AlphabetOrder {
    public static List<Character> order(char[][] alpha) {
        List<Character> fin = new ArrayList<>();
        HashMap<Character, String> ret = new HashMap<>();
        HashSet<Character> inList = new HashSet<>();
        for (int i = 0; i < alpha.length; i++) {
            if (!ret.containsKey(alpha[i][0])) {
                String val = new String("" + alpha[i][1]);
                ret.put(alpha[i][0], val);
            } else {
                String val = ret.get(alpha[i][0]);
                val = val + alpha[i][1];
                ret.put(alpha[i][0], val);
            }
            inList.add(alpha[i][1]);
        }
        Set<Character> first = new HashSet<>(ret.keySet());
        first.removeAll(inList);
        char start = 'c';
        for (Character c: first) {
           start = c;
        }
        fin.add(start);
        int length = ret.keySet().size() + 1;
        int i = 1;
        
        while (i <= length && ret.get(start) != null) {
            String get = ret.get(start);
            start = get.charAt(0);
            if (ret.get(start) != null) {
                for (int j = 1; j < get.length(); j++) {
                    if (ret.get(start).indexOf(get.charAt(j)) == -1) {
                        start = get.charAt(j);
                    }
                }
            }
            fin.add(start);
            i++;
        }
        return fin;
    }

    public static void main(String[] args) {
        char[][] vals = {
            {'a', 'c'},
            {'b', 'c'},
            {'a', 'b'},
            {'d', 'e'},
            {'c', 'd'},
        };
        List<Character> returned = order(vals);
        System.out.println(returned.toString());
    }
}