public class Fibonaci {
    public static int[] fibFinder(int x) {
        int[] ret = new int[x];
        ret[0] = 0;
        ret[1] = 1;
        for (int i = 2; i < x; i++) {
            ret[i] = ret[i - 2] + ret[i - 1];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] vals = fibFinder(10);
        for (int x: vals) {
            System.out.println(x);
        }
    }
}