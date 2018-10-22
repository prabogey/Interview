import java.util.*;

public class FancyNumber {
    public static void main(String[] args) {
        Scanner boi = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = boi.nextInt();
        List<String> result = fancyNumbers(n);
        for (String x: result) {
            System.out.println(x);
        }
    }

    public static List<String> fancyNumbers(int n) {
        HashMap<Character, Character> maps = new HashMap<>();
        maps.put('0', '0');
        maps.put('1', '1');
        maps.put('6', '9');
        maps.put('8', '8');
        maps.put('9', '6');
        if (n == 1) {
            List<String> ret = new ArrayList<>();
            ret.add("0");
            ret.add("1");
            ret.add("8");
            return ret;
        }
        if (n % 2 == 0) {
            return generateEvenNumbers(n, maps);
        } else {
            return generateOddNumbers(n, maps);
        }
    }

    public static List<String> generateEvenNumbers(int n, HashMap<Character, Character> maps) {
        if (n == 2) {
            List<String> ret = new ArrayList<>();
            ret.add("00");
            ret.add("11");
            ret.add("69");
            ret.add("88");
            ret.add("96");
            return ret;
        }
        List<String> twoBelow = generateEvenNumbers(n - 2, maps);
        List<String> ret = new ArrayList<>();
        for (Character c: maps.keySet()) {
            for (int i = 0; i < twoBelow.size(); i++) {
                StringBuilder current = new StringBuilder(twoBelow.get(i));
                current.append(maps.get(c));
                current.insert(0, c);
                ret.add(current.toString());
            }
        }
        return ret;
    }

    public static List<String> generateOddNumbers(int n, HashMap<Character, Character> maps) {
        List<String> evenBelow = generateEvenNumbers(n - 1, maps);
        List<String> ret = new ArrayList<>();
        for (Character c: maps.keySet()) {
            if (c == maps.get(c)) {
                for (int i = 0; i < evenBelow.size(); i++) {
                    StringBuilder current = new StringBuilder(evenBelow.get(i));
                    current.insert(current.length() / 2, c);
                    ret.add(current.toString());
                }
            }
        }
        return ret;
    }
}