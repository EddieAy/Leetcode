package ch12DP;

import java.util.Arrays;

public class Problem674LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new Problem674LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int res = 0;

        for (int i = 1; i < len; i++) {
            if(nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
