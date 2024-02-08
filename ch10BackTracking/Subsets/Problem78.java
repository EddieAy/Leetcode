package ch10BackTracking.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
//        res.add(new ArrayList<>(path));
//        Arrays.sort(nums);
        backtrack(nums,0);

        return res;
    }

    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i + 1);
            path.removeLast();
        }
    }


}
