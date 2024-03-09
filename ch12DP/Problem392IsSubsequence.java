package ch12DP;

public class Problem392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        /*
        * dp[i][j] 表示的是nums[i - 1]   nums[j - 1] 对应的最长公共子序列
        * */
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2] == len1;
    }
}
