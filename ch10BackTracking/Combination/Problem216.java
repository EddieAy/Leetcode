package ch10BackTracking.Combination;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n,k,1,0);
        return res;
    }

    public void backtrack(int n, int k,int start,int sum) {

        if(sum > n){
            return;
        }
        if (path.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9 - (k - path.size()) + 1 ; i++) {
            sum += i;
            path.add(i);
            backtrack(n,k,i + 1,sum);
            sum-=i;
            path.removeLast();
        }
        //16 4  path.size = 1    4 - path.size 1 = 3   7 8 9        start   +   k - path.size = 9 + 1
    }
}
