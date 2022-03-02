public class FindComplement {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            sb.append((binary.charAt(i) == '1') ? '0' : '1');
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int findComplementBinary(int n) {
        int number_of_bits =  
               (int)(Math.floor(Math.log(n) / 
                             Math.log(2))) + 1; 
  
        // XOR the given integer with poe(2, 
        // number_of_bits-1 and print the result 
        return ((1 << number_of_bits) - 1) ^ n; 
    }
}