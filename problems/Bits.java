// for all those bit manipulation questions that no one knows how to do

public class Bits {
    // >> is a arithmetic right shift, it preserves the signdeness of the number
    // when shifting it copies the MSB in the empty bits
    // 1011 >> 3 = 1111
    // >>> is a logical right shift, it just puts 0s in the place of the MSB

    public static int countSetBitsInInteger(int n) {
        // when you subtract one from a number all bits that are off are on
        // the first bit that will be turned off will be the first set bit in the numbers
        // 6 -> 110 : 110 - 1 -> 101 -> 110 & 101 = 100
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

    public static int turnOffKthBit(int n, int k) {
        // every bit will be on except for the bit you want to turn off in your numbers
        int mask = ~(1 << (k - 1));
        return n & mask;
    }

    public static int turnOnKthBit(int n, int k) {
        int mask = 1 << (k - 1);
        return n | mask;
    }

    public static int checkIfKthBitIsSet(int n, int k) {
        int x = n >> (k - 1);
        return ~(x ^ 1);
    }

    public static int toggleKthBit(int n, int k) {
        if (k == 1) {
            return (n | (1 << (k - 1)));
        }
        return (n & ~(1 << (k - 1)));
    }

    public static int unsetRightMostSetBit(int n) {
        return n & (n - 1);
    }

    public static int checkIfNumberIsPowerOf2(int n) {
        // returns 1 if it is power of 2
        // for it to be power of 2 only one bit can be set
        return (1 ^ (n & (n - 1)));
    }

    public static int unsetLeftMostSetBit(int n) {
        int x = n;
        int pos = 0;
        while (x != 0) {
            pos++;
            x = x >> 1;
        }
        return n & ~(1 << (pos - 1));
    }
}