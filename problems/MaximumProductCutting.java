import java.util.*;
// https://www.geeksforgeeks.org/maximum-product-cutting-dp-36/
// DP
public class MaximumProductCutting {
    public static int findMax(int n) {
        HashMap<Integer, Integer> maxAtLength = new HashMap<>();
        maxAtLength.put(1, 1);
        maxAtLength.put(2, 2);
        maxAtLength.put(3, 3);
        for (int i = 4; i <= n; i++) {
           findMaxAtLength(i, maxAtLength);
        }
        return maxAtLength.get(n);
    }

    public static int findMaxAtLength(int n, HashMap<Integer, Integer> maxAtLength) {
        if (maxAtLength.containsKey(n)) {
            return maxAtLength.get(n);
        }
        int ans = -1;
        for (int i = 2; i < n; i++) {
            int x = 0;
            if (maxAtLength.containsKey(n - i)) {
                x = maxAtLength.get(n - i);
            } else {
                x = findMaxAtLength(n - i, maxAtLength);
            }
            int y = maxAtLength.get(i);
            ans = Math.max(ans, x * y);
        }
        maxAtLength.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMax(10));
    }
}