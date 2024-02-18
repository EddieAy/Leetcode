package ch10BackTracking.Subsets;

import java.util.*;

public class Problem491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    public void backtrack(int[] nums,int start){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(used.contains(nums[i]) || (!path.isEmpty() && nums[i] < path.get(path.size() - 1))){
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backtrack(nums,i + 1);
            path.removeLast();
        }
    }

    public void backtrack2(int[] nums,int start){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if(used[nums[i] + 100] == 1 || (!path.isEmpty() && nums[i] < path.get(path.size() - 1))){
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtrack(nums,i + 1);
            path.removeLast();
        }
    }

}
