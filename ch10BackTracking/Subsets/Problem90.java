package ch10BackTracking.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Problem90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    private void backtrack(int[] nums, int start) {

        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i] );
            backtrack(nums,i + 1);
            path.removeLast();
        }
    }
}
