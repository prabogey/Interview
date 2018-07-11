import java.util.*;

public class RomanConverter {
    public static void main(String[] args) {
        System.out.println(convertRomanToInt("IV"));
    }

    public static int convertRomanToInt(String s) {
        HashMap<Character, Integer> conversion = new HashMap<>();
        conversion.put('I', 1);
        conversion.put('V', 5);
        conversion.put('X', 10);
        conversion.put('L', 50);
        conversion.put('C', 100);
        conversion.put('D', 500);
        conversion.put('M', 1000);
        char prev = 'F';
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = conversion.get(s.charAt(i));
            if (( (s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && prev == 'I') {
                // System.out.println(prev);
                curr--;
                ret--;
            } else if (( (s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && prev == 'X') {
                curr -= 10;
                ret -= 10;
            } else if (( (s.charAt(i) == 'D') || (s.charAt(i) == 'M') ) && prev == 'C') {
                curr -= 100;
                ret -= 100;
            }
            ret += curr;
            prev = s.charAt(i);
        }
        return ret;
    }

    public static String intToRoman(int x) {
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.legnth; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}