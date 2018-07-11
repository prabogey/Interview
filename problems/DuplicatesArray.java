import java.util.*;

public class DuplicatesArray {
    public static List<Integer> findDuplicates(int[] arr) {
        HashSet<Integer> ret = new HashSet<>();
        if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                ret.add(arr[0]);
                return new ArrayList<>(ret);
            }
            return new ArrayList<>();
        }
        int middle = arr.length / 2;
        if (arr[middle] == arr[middle - 1]) {
            ret.add(arr[middle]);
        }
        findDuplicates(arr, 0, middle, ret);
        findDuplicates(arr, middle + 1, arr.length - 1, ret);
        return new ArrayList<>(ret);
    }

    public static void findDuplicates(int[] arr, int start, int end, HashSet<Integer> visited) {
        if (start >= end) {
            return;
        }
        if (end - start == 1) {
            if (arr[start] == arr[end] && !visited.contains(arr[start])) {
                visited.add(arr[start]);
                return;
            } 
        }
        int middle = (start + end) / 2;
        if (middle != 0 && arr[middle] == arr[middle - 1] && !visited.contains(arr[middle])) {
            visited.add(arr[middle]);
        }
        findDuplicates(arr, start, middle, visited);
        findDuplicates(arr, middle + 1, end, visited);
    }

    public static List<Integer> findDuplicatesNTime(int[] arr) {
        List<Integer> ret = new ArrayList<Integer>();
        Integer lastDup = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] && (lastDup == null || lastDup != arr[i])) {
                ret.add(arr[i]);
                lastDup = arr[i];
            }
        }
        return ret;
    }

    // passed in a sorted array
    public int removeDuplicates(int[] nums) {
        // have two pointers
        // i is the slow pointer it is building the new array
        // j is the fast pointer
        // whenever you see a duplicate, increment j
        // when you dont see a duplicate increment i and put this first non-duplicate (nums[j]) into nums[i]
        // since the array is sorted it will still be in sorted order
        // if the first 2 elements (or any adjacent elements) are not duplicates then you will just increment i to be equal to j and just
        // put the original value back into the same index in the array (ie nothing will be changed)
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                
            }
        }
        return i + 1;
    }

    // done in less then n^2 time
    // cannot modify the array
    // constant space
    // numbers in the array are from 1...n (n is length of array) inclusive
    public int findDuplicatesConstrained(int[] n) {
        // similar to finding a cycle in a linkedlist
        // since each number is only as big as the size of the array, you cause use the value to index into the array
        // when two indexes link up to the same value then you know you have a duplicate
        // have a slow and a fast pointer
        int slow = n.length;
        int fast = n.length;
        while (slow != fast) {
            slow = n[slow - 1];
            fast = n[n[fast] - 1];
        }
        slow = n.length;
        while (slow != fast) {
            slow = n[slow - 1];
            fast = n[fast - 1];
        }
        return slow;
    } 

    // find duplicates in 2 sorted arrays in constant space
    public static List<Integer> findDuplicatesTwoSorted(int[] a, int[] b) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                ret.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] pass = {1, 5, 7, 8, 11, 15, 20};
        int[] passTwo = {1, 8, 15, 16, 17, 18, 20};
        // List<Integer> val = findDuplicates(pass);
        // List<Integer> val = findDuplicatesNTime(pass);
        // for (int x: val) {
        //     System.out.println(x);
        // }
        List<Integer> val = findDuplicatesTwoSorted(pass, passTwo);
        System.out.println(val.toString());
    }
}