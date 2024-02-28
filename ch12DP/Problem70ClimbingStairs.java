package ch12DP;

public class Problem70ClimbingStairs {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];//0 要占据一个位置
        dp[0] = 1;//至于dp[0] 是几 也不重要
        dp[1] = 1;//这个是1 倒是确认的
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
