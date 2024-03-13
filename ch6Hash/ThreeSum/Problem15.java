package ch6Hash.ThreeSum;

import java.util.*;

public class Problem15 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, -nums[i], i, set);
        }

        return new ArrayList<>(set);
    }

    private static void twoSum(int[] nums, int target, int index, HashSet<List<Integer>> set) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            if (j != index) {
                if (map.containsKey(target - nums[j])) {
                    List<Integer> li = new ArrayList<>();
                    li.add(nums[j]);
                    li.add(target - nums[j]);
                    li.add(-target);
                    Collections.sort(li);
                    set.add(li);
                }
                map.put(nums[j], j);
            }
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> li = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    li.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    //执行 i++ j--
/*                    while (i < j) {
                        if (nums[i] == nums[i + 1]) {
                            i++;
                        } else {
                            break;
                        }
                    }
                    while (i < j) {
                        if (nums[j] == nums[j - 1]) {
                            j--;
                        } else {
                            break;
                        }
                    }*/
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                } else if (sum > 0) {//让 最大的减小
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    while (i < j && nums[i] == nums[++i]) ;
                }
            }
        }

        return li;
    }
}
