package ch12DP;

public class Problem714BestTimetoBuyandSellStockwithFees {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length <= 1) return 0;

        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len ; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
