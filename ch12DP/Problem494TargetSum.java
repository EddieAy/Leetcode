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

    public int findTargetSumWays2(int[] nums, int target){
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0) return 0;
        
        int len = nums.length,neg = diff / 2;
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 0;j <= neg;j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= num){//解释：我们只需找到 j = 0的值，但是你的num  太大了
                    dp[i][j] += dp[i - 1][j - num];//dp[1][0]   += dp[0][0 - 1]
                }
            }
        }
        return dp[len][neg];
        
/*        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = neg; j >= nums[i] ; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[neg];*/
    }
}
