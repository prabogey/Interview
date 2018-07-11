import java.util.Arrays;

public class NextGreatestNumber {
    public static void findNextGreatest(char[] num) {
        int lessThanPrev = num.length - 2;
        while (lessThanPrev >= 0 && (num[lessThanPrev] >= num[lessThanPrev + 1])) {
            lessThanPrev--;
        }
        // lessThanPrev is equal to the index of the first digit that is lower than the digit to the right of it
        if (lessThanPrev == -1) {
            // this means that the number is in descending order
            System.out.println("Not Possible");
        }
        if (lessThanPrev == num.length - 2) {
            // the pointer did not move, meaning the second to last digit is less than the last digit
            // just swap these two
            char c = num[lessThanPrev];
            num[lessThanPrev] = num[lessThanPrev + 1];
            num[lessThanPrev + 1] = c;
        } else {
            // means that we need to find the first digit in the number that is greater than the digit at less than prev
            char digit = num[lessThanPrev];
            int index = num.length - 1;
            while (digit >= num[index]) {
                index--;
            }
            // swap the digit and the first number (from the right) greater than it
            num[lessThanPrev] = num[index];
            num[index] = digit;
            
            // sort the digits from lessThanPrev to the end of the number
            Arrays.sort(num, lessThanPrev + 1, num.length);
        }
        
        for (char c: num) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char digits[] = { '5','3','4','9','7','6' };
        findNextGreatest(digits);
    }
}