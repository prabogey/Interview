public class LetterCombinations {
    // pass in a string of digits (2-9) return all possible letter combinations
    // the letters associated with these numbers are the same as what is on the phone dialpad
    public List<String> findCombo(String digits) {
        LinkedList<String> ret = new LinkedList<>();
        if (digits.isEmpty()) return ret;
        ret.add("");
        String[] mappings = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            while(ret.peek().length() == i) {
                String present = ret.remove();
                for (char c: mappings[digit].toCharArray()) {
                    String add = present + "" + c;
                    ret.add(add);
                }
            }
        }
        return ret;
    }
}