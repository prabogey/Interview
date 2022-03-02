import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// You are given an array of scores
// You want to assign prices to these scores
// The constraints are: you want to minimize price, every scooter must be a dollar
// and if two scooters are adjacent you want the higher score one to have more value

public class Solution {
    public static void main(String args[] ) throws Exception {
        int[] test = {2,4,5,6,7,3,2,1};
        // int[] test = {5,4,3};
        System.out.println(findMinPrice(test));
    }
    
    public static int findMinPrice(int[] scores) {
        int totalPrice = 0;
        int currPrice = 0;
        int length = scores.length;
        int i = 0;
        int[] smallestToRight = new int[length];
        while (i < length - 1) {
            if (scores[i] > scores[i + 1]) {
                if (smallestToRight[i] == 0) {
                    smallestToRight = calculateDecreasePrice(scores, i, length, currPrice);
                }
                int newPrice = smallestToRight[i];
                if (i > 0 && scores[i] > scores[i - 1]) {
                     if (newPrice > currPrice) totalPrice += newPrice;
                     totalPrice = currPrice + 1;
                     currPrice++;
                } else {
                    totalPrice += newPrice;
                }
            } else if (scores[i] <= scores[i + 1]) {
                currPrice++;
                totalPrice += currPrice;
            }
            // System.out.println(totalPrice);
            i++;
        }
        if (scores[i] <= scores[i - 1]) {
            totalPrice++; // 4
        } else {
            totalPrice += ++currPrice;
        }
        return totalPrice;
    }
    
    public static int[] calculateDecreasePrice(int[] scores, int start, int end, int currPrice) {
        int compareStart = start + 1;
        int counter = 0;
        int[] smallestToRight = new int[end];
        Stack<Integer> smallest = new Stack<>();
        smallest.push(start);
        while (compareStart < end && scores[start] > scores[compareStart]) {
            smallest.push(compareStart);
            compareStart++;
        }
        counter = 1;
        while (!smallest.isEmpty()) {
            smallestToRight[smallest.pop()] = counter;
            counter++;
        }
        return smallestToRight;
    }
}

// [1,6,4] -> [1,2,1] -> 4
// [2,4,5,7,3,2] -> [1,2,3,4,2,1]- > 13
// [3,9,8,7,6] -> [1,4,3,2,1] -> 11
// [5,4,3] -> [3,2,1] -> 6
// [4,7,7] -> [1,2,1] -> 4
// [4,7,7,2] -> [1,2,2,1] -> 6
// [2,4,5,6,7,3,1] -> [1,2,3,4,5,3,2,1]- > 21
// [7, 7, 2] = [1, 2, 1]