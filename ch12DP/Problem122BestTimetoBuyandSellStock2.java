package ch12DP;

public class Problem122BestTimetoBuyandSellStock2 {
    public static void main(String[] args) {
        new Problem122BestTimetoBuyandSellStock2().maxProfit(new int[]{7,1,5,3,6,4});
    }
    public int maxProfit2(int[] prices) {
        if(prices.length == 1) return 0;
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= prices.length ; i++) {
            /*
            *dp[i] = dp[i - 1]
            *dp[i] = dp[i - 1] +
            * */
            dp[i] = Math.max(dp[i - 1],dp[i - 1] + prices[i - 1] - prices[i - 2]);
        }
/*        for (int d:dp){
            System.out.printf(d+" ");
        }*/
        return dp[prices.length];
        //0 0 0 4 4 7
    }
    public int maxProfit(int[] prices){
        if(prices.length <= 1) return 0;
        int len = prices.length;
        int[][] dp = new int[len][2];

        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            //1.昨天也持有 今天不变 那就也持有 2.昨天不持有 今天买入了
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] - prices[i]);
            //1.昨天就不持有 今天继续不持有  2.昨天就持有 今天卖了
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}
