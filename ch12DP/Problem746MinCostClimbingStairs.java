package ch12DP;

public class Problem746MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        /*
        * dp[i] 代表的是 到达第i层的花费
        * 确定递推公式：dp[i] = min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2])
        * 初始化： dp[0] = 0 dp[1] = 0
        * cost = [1,100,1,1,1,100,1,1,100,1]
      * dp = 0,0, 1,]
        * */
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length  ; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }
}
