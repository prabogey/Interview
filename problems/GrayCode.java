public class GrayCode {
    public List<Integer> findCode(int x) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < 1<<x; i++) {
            ret.add(i ^ i >> 1); //xor with itself bitshifted 1 right (square rooting the number)
        }
        return ret;
    }
}