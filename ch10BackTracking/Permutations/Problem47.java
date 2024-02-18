package ch10BackTracking.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 1 1 2 .       1 2 1        1 1 2     1 2 1

public class Problem47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Problem47 solution = new Problem47();
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i]  || i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
