import java.util.Arrays;

public class SmallestSumTriplet {
    // passed in an array of 3 arrays
    // find 3 numbers such that the range of these numbers is minimum
    public static void findTriplet(int[][] arr) {
        int[] arr1 = arr[0];
        int[] arr2 = arr[1];
        int[] arr3 = arr[2];
        int n = arr3.length;

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int i = 0;
        int j = 0;
        int k = 0;
        int ret = Integer.MAX_VALUE;
        int ret_low;
        int ret_mid;
        int ret_high;
        while (i < n && j < n && k < n) {
            int sum = arr1[i] + arr2[j] + arr3[k];
            int max = Math.max(Math.max(arr1[i], arr2[j]), arr3[k]);
            int min = Math.min(Math.min(arr1[i], arr2[j]), arr3[k]);
            int diff = max - min;
            if (min == arr1[i]) {
                i++;
            } else if (min == arr[j]) {
                j++;
            } else {
                k++;
            }
            if (diff < ret) {
                ret = diff;
                ret_low = min;
                ret_mid = sum - (max + min);
                ret_high = max;
            }
        }
        System.out.println(ret_low + " " + ret_mid + " " + ret_high);

    }
}