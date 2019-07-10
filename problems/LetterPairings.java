import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// this problem is to find the most common pairings of letters in a dictionary of words
// if two letters appear in the same word they are counted as paired letters
// for each letter in the dictionary you want to have a list of the most common paiirings with that laetter


public class LetterPairings {
    HashMap<Character, HashMap<Character, Integer>> relativeFrequencies = new HashMap<>();
    public HashMap<Character, ArrayList<Character>> output = new HashMap<>();

    public LetterPairings() {

    }

    public void addWord(String s) {
        for (int i = 0; i < s.length(); i++) {
            Character current = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                Character compare = s.charAt(j);
                if (!relativeFrequencies.containsKey(current)) {
                    HashMap<Character, Integer> freq = new HashMap<>();
                    freq.put(compare, 1);
                    relativeFrequencies.put(current, freq);
                } else {
                    HashMap<Character, Integer> freq = relativeFrequencies.get(current);
                    freq.put(compare, freq.getOrDefault(compare, 0) + 1);
                    relativeFrequencies.put(current, freq);
                }
            }
            ArrayList<Character> mostCommon = new ArrayList<>();
            HashMap<Character, Integer> freq = relativeFrequencies.get(current);
            int max = Integer.MIN_VALUE;
            for (Character key: freq.keySet()) {
                if (freq.get(key) > max) {
                    max = freq.get(key);
                }
            }
            for (Character key: freq.keySet()) {
                if (freq.get(key) == max) {
                    mostCommon.add(key);
                }
            }
            output.put(current, mostCommon);
        }
    }

    public void addWords(String[] s) {
        for (String word: s) {
            addWord(word);
        }
    }

    public static void main(String[] args) {
        LetterPairings letterPairings = new LetterPairings();
        String[] words = {"abc", "bcd", "cde"};
        letterPairings.addWords(words);
        HashMap<Character, ArrayList<Character>> output = letterPairings.output;
        for (Character key: output.keySet()) {
            System.out.print(key + ": ");
            ArrayList<Character> result = output.get(key);
            for (Character c: result) {
                System.out.print(c + ", ");
            }
            System.out.println();
        }
    }
}
