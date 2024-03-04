package ch12DP;

public class Problem494TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        * 一定会有 left - right = target  石头问题
        *
        * dp[ i ][ j ] = dp[ i - 1 ][ j - nums[ i ] ] + dp[ i - 1 ][ j + nums[ i ] ]
        * */
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        if(Math.abs(target) > sum) return 0;
        int len = nums.length;
        int range = sum * 2 + 1;
        int[][] dp = new int[len][range];
        dp[0][sum + nums[0]] +=1;
        dp[0][sum - nums[0]] +=1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum ; j++) {
                if((j+nums[i]) > sum){
                    dp[i][j+sum] = dp[i - 1][j - nums[i] + sum] + 0;
                }else if((j - nums[i]) < -sum){
                    dp[i][j+sum] = dp[i - 1][j + nums[i] + sum] + 0;
                }else {
                    dp[i][j + sum] = dp[i-1][j+nums[i]+sum]+dp[i-1][j-nums[i]+sum];
                }
            }
        }

        return dp[len - 1][sum + target];
    }
}
