public class SumSquares {
    public static void main(String[] args) {
        int x = 100;
        System.out.println(findSumSquares(x));
    }

    public static int findSumSquares(int x) {
        int[] vals = new int[x + 1];
        vals[0] = 0;
        vals[1] = 1;
        vals[2] = 2;
        vals[3] = 3;
        for (int i = 4; i <= x; i++) {
            vals[i] = i;
            for (int j = 1; j <= x; j++) {
                int square = j * j;
                if (square > i) {
                    break;
                }
                vals[i] = Math.min(vals[i], 1+vals[i - square]);
            }
        }
        return vals[x];
    }
}