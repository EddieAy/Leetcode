package ch12DP;

public class Problem53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        int res = nums[0];
        for (int i = 1; i <=nums.length;i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1],nums[i - 1]);
            if(dp[i] > res) res = dp[i];
        }

        return res;
    }
}
