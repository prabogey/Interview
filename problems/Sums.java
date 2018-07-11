import java.util.*;

public class Sums {
    public static void main(String[] args) {
        Integer[] x = {1,2,3,4,5};
        Integer[] z = {4,5,3,1,2};
        int target = 11;
        ArrayList<ArrayList<Integer>> vals = threeSumBetter((int[]) x, target);
        for (ArrayList<Integer> v: vals) {
            System.out.println(v.toString());
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        for (Integer y: x) {
            arr1.add(y);
        }
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (Integer y: z) {
            arr2.add(y);
        }
        System.out.println(arr1.hashCode() == arr2.hashCode());

    }

    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 3) { return ret; }
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    if (!visited.contains(tmp)) {
                        visited.add(tmp);
                        ret.add(tmp);
                    }
                    start++;
                    end--;
                } else {
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
                
            }
        }
        return ret;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length < 4) { return ret; }
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            for (int j = i + 1; j <= nums.length - 3; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        if (!visited.contains(tmp)) {
                            visited.add(tmp);
                            ret.add(tmp);
                        }
                        start++;
                        end--;
                    } else {
                        if (sum > target) {
                            end--;
                        } else {
                            start++;
                        }
                    }

                }
            }
        }
        return ret;      
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int ret = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    ret = sum;
                }
                if (sum  > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }

    public static ArrayList<ArrayList<Integer>> threeSumBetter(int[] nums, int target) {
        HashMap<Integer, ArrayList<Integer[]>> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer[] points = {i, j};
                if (map.get(nums[i] + nums[j]) == null) {
                    ArrayList<Integer[]> a  = new ArrayList<>();
                    a.add(points);
                    map.put(nums[i] + nums[j], a);
                } else {
                    ArrayList<Integer[]> ret = map.get(nums[i] + nums[j]);
                    ret.add((Integer[]) points);
                    map.put(nums[i] + nums[j], ret);
                }
            }
        }
        ArrayList<ArrayList<Integer>> returned = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null) {
                ArrayList<Integer[]> vals = map.get(diff);
                for (Integer[] x: vals) {
                    if (i != x[0] && i != x[1]) {
                        ArrayList<Integer> threePoints = new ArrayList<>();
                        threePoints.add(i);
                        threePoints.add(x[0]);
                        threePoints.add(x[1]);
                        returned.add(threePoints);
                    }
                }
            }
        }
        return returned;

    }
}