public class TrappingRainWater {
    // the intuition behind this problem is that we need to precompute all max bars to the left of a bar
    // and all max bars to the right of a bar
    // include current bar in both precomputations
    // this allows us to create a sort of ceiling and the difference from this ceiling to your floor (curr bar height) 
    // is how much rain water can be trapped inside
    public int trappedWater(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        left[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            left[i] = Math.max(left[i - 1], heights[i]);
        }

        right[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i > -1; i++) {
            right[i] = Math.max(right[i + 1], heights[i]);
        }

        int trappedWater = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            trappedWater += Math.min(right[i], left[i]) - heights[i];
        }
        return trappedWater;
    }
}