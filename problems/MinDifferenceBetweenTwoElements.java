import java.util.Arrays;

// https://www.geeksforgeeks.org/find-minimum-difference-between-any-two-elements-set-2/

public class MinDifferenceBetweenTwoElements {
    public static int minDifference(int[] arr) {
        Arrays.sort(arr);
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDistance = Math.min(minDistance, arr[i] - arr[i - 1]);
        }
        return minDistance;
    }

    public static void main(String[] args) {
        int[] test = {10, 2, 6, 4, 8, 12, 15, 40, 41, 25, 13};
        System.out.println(minDifference(test));
    }
}