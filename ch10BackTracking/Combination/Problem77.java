package ch10BackTracking.Combination;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> temp = new Problem77().combine(5,3);
    }

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return res;
    }

    public void backtrack(int n,int k,int startIndex){
        if (ans.size() == k){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i <= n ; i++) {
            ans.add(i);
            System.out.println("递归之前的ans" + ans + " 此时的i = " + i + " 此时的start = " + startIndex);
            backtrack(n,k,i+1);
            ans.remove(ans.size() - 1);
            System.out.println("递归之后的ans" + ans + " 此时的i = " + i + " 此时的start = " + startIndex);
        }
    }
}
