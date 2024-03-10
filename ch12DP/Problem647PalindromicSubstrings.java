package ch12DP;

public class Problem647PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new Problem647PalindromicSubstrings().countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = i; j < len ; j++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i <= 1){
                        res++;
                        dp[i][j] = true;
                    }else if(dp[i + 1][j - 1]){
                        res++;
                        dp[i][j] = true;
                    }
                }
                printDP(dp);
            }
        }
        return res;
    }

    private void printDP(boolean[][] dp) {
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf(dp[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
