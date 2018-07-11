public class Subset {
    // this method returns the power set of the set of numbers
    public List<List<Integer>> findPowerSet(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>()); // every power set has the empty set
        for (int x: nums) {
            int size = ret.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(ret.get(i));
                subset.add(x);
                ret.add(subset);
            }
        }
        return ret;
    }
}