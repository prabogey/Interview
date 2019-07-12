import java.util.*;
// https://www.geeksforgeeks.org/split-the-array-into-equal-sum-parts-according-to-given-conditions/
// kind of a bad run time O(2^N)

// TODO: find a memoized solution if there is one
public class SplitArrayEqualSumGivenConditions {
    public static boolean canSplit(int[] arr) {
        Stack<Integer> neither = new Stack<>();

        int fiveSum = 0;
        int threeSum = 0;
        int neitherSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 5 == 0) {
                fiveSum += arr[i];
            } else if (arr[i] % 3 == 0) {
                threeSum += arr[i];
            } else {
                neither.add(arr[i]);
                neitherSum++;
            }
        }
        HashMap<Integer, Integer> threeMap = new HashMap<>();
        HashMap<Integer, Integer> fiveMap = new HashMap<>();
        Stack<Integer> saved = new Stack<>();
        saved.addAll(neither);
        if (helperFive(fiveSum , threeSum, neither.pop(), neither, threeMap, fiveMap)) {
            return true;
        }
        if (helperThree(fiveSum, threeSum, saved.pop(), saved, threeMap, fiveMap)) {
            return true;
        }
        return false;
    }

    public static boolean helperFive(int fiveSum, int threeSum, int adding, Stack<Integer> neither, HashMap<Integer, Integer> threeMap, HashMap<Integer, Integer> fiveMap) {
        fiveSum += adding;
        if (neither.isEmpty() && fiveSum == threeSum) return true;
        if (neither.isEmpty()) return false;
        Stack<Integer> saved = new Stack<>();
        saved.addAll(neither);
        if (helperFive(fiveSum, threeSum, neither.pop() + adding, neither, threeMap, fiveMap)) {
            return true;
        }
        if (helperThree(fiveSum, threeSum, saved.pop() + adding, saved, threeMap, fiveMap)) {
            return true;
        }
        return false;
    }

    public static boolean helperThree(int fiveSum, int threeSum, int adding, Stack<Integer> neither, HashMap<Integer, Integer> threeMap, HashMap<Integer, Integer> fiveMap) {
        threeSum += adding;
        if (neither.isEmpty() && fiveSum == threeSum) return true;
        if (neither.isEmpty()) return false;
        Stack<Integer> saved = new Stack<>();
        saved.addAll(neither);
        if (helperFive(fiveSum, threeSum, neither.pop() + adding, neither, threeMap, fiveMap)) {
            return true;
        }
        if (helperThree(fiveSum, threeSum, saved.pop() + adding, saved, threeMap, fiveMap)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] test = {1, 3, 4};
        System.out.println(canSplit(test));
        int[] test1 = {1, 2};
        System.out.println(canSplit(test1));

    }
}