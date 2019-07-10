// this problem is trying to get the maximum subarray sum to equal or be less than a target.
public class QualtricsArray {
    private static int findMaxSubArrayToTarget(int[] arr, int target) {
        int retSize = arr.length + 1;
        int low = 0;
        int high = 1;
        int sumNow = -1;
        // this is building up a sub array that is equal to or greater than the target
        // if it is greater, then keep removing elements from the front
        // until you have equaled target or are under it
        // keep track of the size of this sub array
        // slinding window technique application
        while (high < arr.length) {
            while (sumNow <= target && high < arr.length) {
                sumNow += arr[high++];
            }
            if (sumNow >= target && high - low < retSize) {
                retSize = high - low;
            }
            while (sumNow > target && low < arr.length) {
                if (high - low < retSize) {
                    retSize = high - low;
                }
                sumNow -= arr[low++];
            }
            if (sumNow >= target && high - low < retSize) {
                retSize = high - low;
            }
        }
        return retSize;
    }

    public static void main(String[] args) {
        int[] x = {5, 8, 10, 2, 6, 7, 13, 15, 20, 30, 4};
        int result = findMaxSubArrayToTarget(x, 65);
        System.out.println(result);
    }
}