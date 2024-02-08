package ch10BackTracking.Segment;

import java.util.ArrayList;
import java.util.List;

public class Problem131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> res = new Problem131().partition("aab");
    }

    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }

    private void backtrack(String s, int start) {
        if(start >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String substr = s.substring(start,i + 1);
            if(isPalindrome(substr)){
                path.add(substr);
            }else {
                continue;
            }
            backtrack(s,i + 1);
            path.removeLast();
        }
    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        int i = 0;
        int j = len - 1;
        for (;i < j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
