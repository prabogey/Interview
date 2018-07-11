import java.util.*;

public class BlueFinder {
    public static List<Integer> findBlue(String s) {
        List<Integer> ret = new ArrayList<Integer>();
        int i = 0;
        while (i < s.length() - 3) {
            int start = i;
            int end = i + 3;
            if (s.charAt(start) == 'b' && s.charAt(end) == 'e') {
                start++;
                end--;
                if (s.charAt(start) == 'l' && s.charAt(end) == 'u') {
                    ret.add(i);
                    i += 3; // skip to end of blue
                }
            }
            i++;
        }
        return ret;
    }

    public static List<Integer> findWord(String s, String w) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = w.length();
        while (i <= s.length() - j) {
            if (s.substring(i, i + j).equals(w)) {
                ret.add(i);
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "bluebluebugblue";
        List<Integer> vals = findWord(s, "bu");
        System.out.println(vals.toString());
    }
}