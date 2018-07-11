import java.util.*;

public class KClosest {
    public static List<Integer> kClose(int[] arr, int target, int k) {
        // this list is sorted
        // use binary search to find the crossover point
        // simply cant just search for the target, as the target might not be there
        // once you find crossover point
        // keep a left and right counter, add then to list you are returning too
        List<Integer> ret = new ArrayList<>();
        int middle = binarySearch(arr, target, 0, arr.length - 1);
        int left = middle - 1;
        int right = middle;
        if (arr[right] == target) {
            right++;
        }
        while (ret.size() < k && left >= 0 && right < arr.length) {
            if (Math.abs(target - arr[left]) <= Math.abs(arr[right] - target)) {
                ret.add(arr[left]);
                left--;
            } else {
                ret.add(arr[right]);
                right++;
            }
        }
        if (ret.size() < k && left >= 0 && right == arr.length) {
            while (ret.size() < k && left >= 0) {
                ret.add(arr[left]);
                left--;
            }
        }
        if (ret.size() < k && left < 0 && right < arr.length) {
            while (ret.size() < k && right < arr.length) {
                ret.add(arr[right]);
                right++;
            }
        }
        return ret;

    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if (target <= arr[start]) {
            return start;
        }
        if (target >= arr[end]) {
            return end;
        }
        int middle = (start + end) / 2;
        if (arr[middle] <= target && arr[middle + 1] > target) {
            return middle;
        }
        if (arr[middle + 1] < target) {
            return binarySearch(arr, target, middle + 1, end);
        } else if (arr[middle] > target) {
            return binarySearch(arr, target, start, middle - 1);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5, 6, 8, 10, 14, 20, 40, 50};
        int target = 25;
        List<Integer> result = kClose(x, target, 4);
        System.out.println(result.toString());
    }
}