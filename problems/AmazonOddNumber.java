// You are given an integer array, where all numbers except for TWO numbers appear even number of times. 

// Q: Find out the two numbers which appear odd number of times.

import java.util.*;

public class AmazonOddNumber {
    public static List<Integer> oddNumberFinder(int[] arr) {
        ArrayList<Integer> results = new ArrayList<>();
        HashSet<Integer> ret = new HashSet<>(); // stores the numbers youve seen an odd times
        for (int i = 0; i < arr.length; i++) {
            if (ret.contains(arr[i])) {
                ret.remove(arr[i]); // if its already in the set and you see it again you can remove it since youve seen it an even # times
            } else {
                ret.add(arr[i]); // if you see a number thats not in the set add it, now you have seen it an odd # times
            }
        }
        for (Integer i: ret) {
            results.add(i);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] pass = { 1, 2, 3, 4, 5, 2, 4, 5, 3, 4, 5, 1 };
        List<Integer> al = oddNumberFinder(pass);
        for (Integer x: al) {
            System.out.println(x);
        }
    }
}