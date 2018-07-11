public class PermutationsString {
    public static void main(String[] args) {
        String pass = "ABC";
        // System.out.println(pass);
        permute(pass, 0, pass.length() - 1);
    }

    public static void permute(String s, int l, int r) {
        if (l == r) {
            System.out.println(s);
        } else {
            for (int i = l; i <= r; i++) {
                s = swap(s, l, i);
                permute(s, l + 1, r);
                s = swap(s, l, i);
            }
        }
    }

    public static String swap(String s, int l, int r) {
        char[] chArr = s.toCharArray();
        char tmp = chArr[l];
        chArr[l] = chArr[r];
        chArr[r] = tmp;
        return String.valueOf(chArr);
    }
}