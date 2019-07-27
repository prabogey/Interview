// https://leetcode.com/problems/maximum-product-subarray/submissions/

public class MaxProductSubarrayWithNegatives {
    public int maxProduct(int[] A) {
        // Keep track of min product and max product
        // if number is negative then the min product becomes the max product
        // keep this running total of both and update the result as you go
        return helper(A);
    }
    
    public int helper(int[] A) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        int imax = r;
        int imin = r;
        for (int i = 1; i < A.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}