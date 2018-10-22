public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 0; i < nums.length; i++) {
            result[i] *= temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for(int i = nums.length - 1; i > -1; i--) {
            result[i] *= temp;
            temp = temp * nums[i];
        }
        return result;
    }
}
