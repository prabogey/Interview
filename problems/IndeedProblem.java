public class IndeedProblem {
    public static void main(String[] args) {
        String pass = "This job is meant for comptuer science professionals in the field of";
        System.out.println(edit(pass, 30));
    }

    public static String edit(String s, int k) {
        StringBuilder newString = new StringBuilder(k + 1);
        newString.append(s.substring(0, k + 1));
        if (newString.charAt(k) != ' ') {
            int end = newString.length() - 1;
            while (newString.charAt(end) != ' ') {
                newString.deleteCharAt(end);
                end--;
            }
        }
        newString.deleteCharAt(newString.length() - 1);
        return newString.toString();
    }
}