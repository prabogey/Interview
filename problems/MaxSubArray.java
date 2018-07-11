public class MaxSubArray {
    // find a sub array with the maximum sum
    public int findMax(int[] A) {
        int maxSoFar = A[0];
        int maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i){
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);	
        }
        return maxSoFar;
    }
}