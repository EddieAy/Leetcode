package ch12DP;

public class Problem1143LongestCommonSubsequence {

    public static void main(String[] args) {
        String t1 = "abcde";
        String t2 = "ace";
        System.out.println(new Problem1143LongestCommonSubsequence().longestCommonSubsequence(t1,t2));
    }

    /*
    * "abcde", text2 = "ace"
     * [a,b,c,d,e]  [a,c,e]
     *以
     * dp[i][j] =
    * */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int res = 0;
        for (int i = 1; i <= len1 ; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }

        }
/*        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        return dp[len1][len2];
    }
}
