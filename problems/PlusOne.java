public class PlusOne {
    public static int[] addOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        int num = digits[i] + 1 + carry;
        digits[i] = num % 10;
        carry = num / 10;
        i--;
        while (carry != 0 && i >= 0) {
            num = digits[i] + carry;
            digits[i] = num % 10;
            carry = num / 10;
            i--;
        }
        if (carry == 1) {
            int[] newInt = new int[digits.length + 1];
            newInt[0] = 1;
            return newInt;
        }
        return digits;
    }
}