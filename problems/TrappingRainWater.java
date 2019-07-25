public class TrappingRainWater {
	public int trappedWater(int[] heights) {
		int[] left = new int[heights.length];
		int[] right = new int[heights.length];

		left[0] = heights[0];
		for (int i = 1; i < heights.length; i++) {
			left[i] = Math.max(left[i - 1], heights[i]);
		}

		right[heights.length - 1] = heights[hights.length - 1];
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