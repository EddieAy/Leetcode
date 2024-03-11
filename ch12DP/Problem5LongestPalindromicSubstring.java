package ch12DP;

public class Problem5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int maxLen = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if (j - i <= 2){
                        /*
                        * j - i = 0 说明 同一个字符 j - i = 1 说明aa  j - i = 2  说明 aba
                        *
                        * */
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start + maxLen);
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        int start = 0;
        int maxLen = 1;
        for (int i = len - 1; i >= 0 ; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                if(chs[i] == chs[j]){
                    if (j - i <= 2){
                        /*
                         * j - i = 0 说明 同一个字符 j - i = 1 说明aa  j - i = 2  说明 aba
                         *
                         * */
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }else {
                    dp[i][j] = false;
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start + maxLen);
    }
}
