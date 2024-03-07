package ch12DP;

public class Problem121BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        new Problem121BestTimetoBuyandSellStock().maxProfit2(new int[] {7,1,5,3,6,4});

    }
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        int minPrice = prices[0];
        for (int i = 2; i <= prices.length ; i++) {
            minPrice = Math.min(minPrice,prices[i - 1]);
            dp[i] = Math.max(dp[i - 1],prices[i - 1] - minPrice);

        }
/*        for (int i = 0; i < dp.length; i++) {
            System.out.printf(dp[i] + " ");
        }*/
        return dp[prices.length];
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 1) return 0;
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length ; i++) {
            if(prices[i] <= minPrice){
                minPrice = prices[i];
            }else {
                maxProfit = Math.max(maxProfit,prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices){
        int len = prices.length;
        if(len <= 1) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],-prices[i]);
            /*
            今天持有，1.以前买入的 2.今天买入的 = 扣除买入的钱
            今天不持有：1.昨天就卖了=昨天就不持有了  2.今天才卖  = 昨天的现金（昨天持有 当时拥有的钱） + 今天卖出去的价格
            * */
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] + prices[i]);
        }
        return dp[len - 1][1];
    }
}
