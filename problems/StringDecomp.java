// https://techdevguide.withgoogle.com/paths/advanced/compress-decompression/#!

public class StringDecomp {
    public static String decomp(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        StringBuilder temp = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                int recurse = Integer.parseInt(temp.toString());
                ResultWrapper result = decompHelper(s, i + 1, recurse);
                temp = new StringBuilder();
                builder.append(result.result);
                i = result.end;
            } else if (Character.isDigit(s.charAt(i))) {
                temp.append(s.charAt(i));
                i++;
            } else if (s.charAt(i) != ']') {
                builder.append(s.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }

    public static ResultWrapper decompHelper(String s, int start, int multiplier) {
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while (s.charAt(start) != ']') {
            if (Character.isDigit(s.charAt(start))) {
                StringBuilder num = new StringBuilder();
                while (s.charAt(start) != '[') {
                    num.append(s.charAt(start));
                    start++;
                }
                int recurse = Integer.parseInt(num.toString());
                ResultWrapper result = decompHelper(s, ++start, recurse);
                start = result.end;
                temp.append(result.result);
            } else {
                temp.append(s.charAt(start));
                start++;
            }
        }
        for (int i = 0; i < multiplier; i++) {
            builder.append(temp);
        }
        return new ResultWrapper(++start, builder.toString());
    }

    public static void main(String[] args) {
        String test = "2[a3[b]c]d";
        System.out.println(decomp(test));
    }

    static class ResultWrapper {
        Integer end;
        String result;
        public ResultWrapper(Integer end, String result) {
            this.end = end;
            this.result = result;
        }
    }
}