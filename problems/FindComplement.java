public class FindComplement {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            sb.append((binary.charAt(i) == '1') ? '0' : '1');
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    // TODO: implement the real thing without library functions
}