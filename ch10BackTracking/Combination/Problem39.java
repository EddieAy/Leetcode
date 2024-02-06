package ch10BackTracking.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem39 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 1 && target != candidates[0]) return res;
        Arrays.sort(candidates);

        backtrack(candidates,target,0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target,int sum,int start) {
        if(sum > target){
            return;
        }

        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && sum + candidates[i] <= sum; i++) {
            /*
            * 你想的是从0开始，这样就可以重复使用了。但是这样会导致2 2 3  2 3 2
            * 重复使用的解决 使用的是  startindex  = i
            * */
            path.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,sum,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
