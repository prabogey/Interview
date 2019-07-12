import java.util.*;

// https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
public class MaximumDistanceOfIndexes {
    // Keep two stacks
    // One tracks the min seen until a point
    // The other tracks the max seen until a point
    // It is VERY possible that the max stack will have elements smaller than the min stack
    // this is accounted for in the while loop
    // if the maxStack.peek() is less than minStack.peek() that means there is a value smaller
    // than maxStack.peek() that has already been processed
    // this is because if maxStack.peek() was small enough at the given index it would have
    // been in the minStack. This pattern arises because
    // we are filling in these stacks in ascending order
    // each stack is ordering in ascending order
    public static int maxDistance(int[] arr) {
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        minStack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[minStack.peek()]) {
                maxStack.push(i);
            } else if (i != arr.length - 1 && arr[i] < arr[minStack.peek()]) {
                // we dont care about the last element if its the smallest in the array
                // since there is no number after it, its maxDistance is always 0
                minStack.push(i);
            }
        }

        int ans = 0;
        while (!minStack.empty() && !maxStack.empty()) {
            int min = minStack.peek();
            int max = maxStack.peek();
            if (arr[min] <= arr[max]) {
                minStack.pop();
                ans = Math.max(ans, max - min);
            } else {
                maxStack.pop();
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] test = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxDistance(test));
    }
}