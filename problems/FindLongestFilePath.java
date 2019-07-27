import java.util.*;

public class FindLongestFilePath {
    public static int findLongestPath(String file) {
        String[] splitted = file.split("\n");
        List<String[]> found = new ArrayList<>();
        Stack<String> curr = new Stack<>();
        int max = 0;

        curr.add(splitted[0]);
        int lastTab = 0;
        String currentString = "";

        for (int i = 1; i < splitted.length; i++) {
            currentString = splitted[i];
            String withoutTabs = countTabs(currentString);
            int tabs = currentString.length() - withoutTabs.length();
            if (tabs == lastTab + 1) {
                curr.add(withoutTabs);
                lastTab = tabs;
            } else if (tabs == lastTab || tabs > lastTab + 1) {
                int newMax = processStack(curr);
                max = Math.max(newMax, max);
                int difference = tabs - lastTab + 1;
                int j = 0;
                while (j < difference) {
                    String x = curr.pop();
                    j++;
                }
                curr.add(withoutTabs);
                lastTab = tabs;
            }
        }
        return Math.max(max, processStack(curr));
    }

    private static String countTabs(String s) {
        return s.replace("\t", "");
    }

    private static int processStack(Stack<String> curr) {
        if (curr.peek().indexOf(".") == -1) return 0;
        Stack<String> newCurr = (Stack<String>) curr.clone();
        int count = -1;
        while (!newCurr.isEmpty()) {
            count += newCurr.pop().length() + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}