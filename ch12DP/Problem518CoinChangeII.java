package ch12DP;

public class Problem518CoinChangeII {
    public static void main(String[] args) {
        System.out.println(new Problem518CoinChangeII().change2(5,new int[]{1,2,5}));
    }
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
//        dp[0][0] = 0;

        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= len ; i++) {
            for (int j = 0;j <= amount;j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= coins[i - 1]){
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][amount];
    }

    public int change2(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
//        dp[0][0] = 0;

/*        for (int i = 0; i <= len; i++) {
            dp[i][0] = 1;
        }*/
        dp[0] = 1;

        for (int i = 0; i < len ; i++) {
            for (int j = coins[i];j <= amount;j++){
                dp[j] += dp[j - coins[i]];
            }
            for (int k = 0; k < dp.length; k++) {
                System.out.printf(dp[k]+" ");
            }
            System.out.println();
        }
        return dp[amount];
    }
}
