import java.util.*;

public class UnionArrays {
    public static List<Integer> union(int[] a, int[] b) {
        List<Integer> ret = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                if (!vis.contains(a[i])) {
                    ret.add(a[i]);
                    vis.add(a[i]);
                }
                i++;
            } else {
                if (!vis.contains(b[j])) {
                    ret.add(b[j]);
                    vis.add(b[j]);
                }
                j++;
            }
        }
        if (i >= a.length) {
            for (int x = j; x < b.length; x++) {
                if (!vis.contains(b[x])) {
                    ret.add(b[x]);
                    vis.add(b[x]);
                }
            }
        } else if (j >= b.length) {
            for (int x = i; x < a.length; x++) {
                if (!vis.contains(a[x])) {
                    ret.add(a[x]);
                    vis.add(a[x]);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {2,10,14,19,51,71};
        int[] b = {2,9,19,40,51};
        List<Integer> vals = union(a, b);
        System.out.println(vals.toString());
    }
}