package ch12DP;

public class Problem309BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        /*
        * 想清楚 几个状态
        * 1.今天不持有   （1）昨天也不持有 dp[i][1] = dp[i - 1][1]   (2)昨天持有 今天卖了 dp[i][1] = dp[i - 1][0] + prices[i] (3)昨天之前就卖了 今天
        * 2.今天持有      (1)昨天持有 dp[i][0] = dp[i - 1][0]  (2) 昨天没有 今天持有 dp[i][0] = dp[i - 1][1] - prices[i]
        *
        * */
        int len = prices.length;
        int[][] dp = new int[len][4];

        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],Math.max(dp[i - 1][3] - prices[i],dp[i - 1][1] - prices[i]));//dp[i - 1][3] - prices[i]
            //昨天买了 今天不动         昨天冷冻 今天买        昨天股票是卖出的状态（虽然不一定是昨天卖）
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            //前一天就是卖出股票状态，一直没操作        两天前就卖出了股票，度过一天冷冻期 相当于前一天是冷冻期
            dp[i][2] = dp[i - 1][0] + prices[i];
            //达到今天就卖出股票状态 = 昨天一定是持有股票状态（状态一），今天卖出
            dp[i][3] = dp[i - 1][2];
            //昨天卖出了股票
        }
        return Math.max(dp[len - 1][1],Math.max(dp[len - 1][2],dp[len - 1][3]));

    }
}
