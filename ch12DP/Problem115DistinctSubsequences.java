package ch12DP;

public class Problem115DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        /*
        * **定义状态：**设 dp[i][j] 表示字符串 s 的前 i 个字符中，字符串 t 的前 j 个字符作为子序列出现的个数。
        *
        * */
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
