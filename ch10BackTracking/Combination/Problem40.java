package ch10BackTracking.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    public static void main(String[] args) {
        List<List<Integer>> res = new Problem40().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0,-1);
        return res;
    }
    /*
    * 1 2 2 2 5   2 pre = 1   2 != 1   pre = 2      2
    * 1 2 2
    * 1 2   2
    *
    * */
    private void backtrack(int[] candidates, int target, int sum, int start,int pre) {
        if(target < sum){
            return;
        }
        if(target == sum){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length && candidates[i] + sum <= target; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,sum,i + 1,pre);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
