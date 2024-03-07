package ch12DP;

public class Problem188BestTimetoBuyandSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1) return 0;
        int len = prices.length;
        int status = 2 * k;
        int[][] dp = new int[len][status];
        for (int i = 0; i <= status; i++) {
            dp[0][i] = i % 2 == 0?0:-prices[0];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j <= status; j++) {
                if(j % 2 == 1){
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - 1] - prices[i]);
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - 1] + prices[i]);
                }
            }
        }
        return dp[len - 1][status - 1];
    }
}
