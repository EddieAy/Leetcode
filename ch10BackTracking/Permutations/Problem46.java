package ch10BackTracking.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new boolean[nums.length]);
        return res;
    }

    public void backtrack(int[] nums,boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] == true){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
