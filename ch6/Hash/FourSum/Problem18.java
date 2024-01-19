package ch6.Hash.FourSum;

import java.util.*;

public class Problem18 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        int part = nums.length / 4;

        for (int i = 0; i < part; i++) {
            for (int j = part; j < 2 * part; j++) {
                if (!map.containsKey(nums[i] + nums[j])) map.put(nums[i] + nums[j],new ArrayList<>());
                ArrayList<Integer> inside1 = new ArrayList<>();
                inside1.add(i);
                inside1.add(j);
                map.get(nums[i] + nums[j]).add(inside1);
            }
        }

        for (int i = 2 * part; i < 3 * part; i++) {
            for (int j = 3 * part; j < nums.length; j++) {
                if (map.containsKey(target - (nums[i] + nums[j]))){
                    for(ArrayList<Integer> inside:map.get(  target - (nums[i] + nums[j])  )){
                        List<Integer> li = new ArrayList<>();
                        li.add(inside.getFirst());
                        li.add(inside.getLast());
                        li.add(i);
                        li.add(j);
                        res.add(li);
                    }
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > 0 && nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1,l = nums.length - 1;
                while (k < l){
                    long sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        while (k < l && nums[k] == nums[++k]);
                        while (k < l && nums[l] == nums[--l]);
                    } else if (sum > target) {
                        l--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
