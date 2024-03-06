package ch12DP;

public class Problem198HouseRobber {

    /*
    * dp[j] 表示一夜之内能偷的最高金额
    * 递推： dp[j] += Math.max(dp[j - 2],dp[j - 3])
    * dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i])
    * */

    public static void main(String[] args) {
        System.out.println(new Problem198HouseRobber().rob(new int[]{1,2,3,1}));
    }
    public int rob(int[] nums) {//nums 0 nums.length - 1
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        if(nums.length == 1) return nums[0];
        for (int i = 2; i <= nums.length;i++){
            dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
