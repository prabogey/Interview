public class NonDecreasingArray {
    // an array is non decreasing if all of its elements are in increasing order
    // if you can make one change to the array to make it non-decreasing, then the array is still non-decreasing
    public static boolean isDecreasing(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                count++;
                if (i != 0 && arr[i - 1] > arr[i + 1]) {
                    // make the one edit, so you do not double count this 
                    // if we did arr[i] = arr[i + 1] then you would need more than edit to transform it  
                    arr[i + 1] = arr[i];
                } else {
                    arr[i] = arr[i + 1];
                }
            }
        }
        return count <= 1;
    }
}