public class RemoveElement {
    public int removeElementInPlaceOpt(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == val) {
                nums[i] = nums[length - 1];
                length--;
            } else {
                i++;
            }
        }
        return length;
    }
}