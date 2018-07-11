public class Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        int i = 1;
        while(i < strs.length && !prefix.equals("")) {
            String compTwo = strs[i];
            int length = Math.min(compTwo.length(), prefix.length());
            int j = 0;
            while (j < length && compTwo.charAt(j) == prefix.charAt(j) ) {
                j++;
            }
            prefix = compTwo.substring(0, j);
            i++;
        }
        return prefix;
    }

    //TODO: rewrite with a Trie

    public String longestCommonPrefixHorizontalScanning(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }

    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";    
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }
    
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
       }
    }
    
    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());       
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}