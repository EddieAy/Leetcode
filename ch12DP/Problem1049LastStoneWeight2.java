package ch12DP;

public class Problem1049LastStoneWeight2 {
    public int lastStoneWeightII(int[] stones) {
        int[] dp = new int[30 * 100 / 2 + 1];
        int sum = 0;
        for (int stone:stones) sum+=stone;
        int target = sum / 2;

        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];//一堆石头 减去另一堆石头
    }
}


