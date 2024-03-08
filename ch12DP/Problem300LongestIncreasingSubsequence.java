package ch12DP;

import java.util.Arrays;

public class Problem300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(new Problem300LongestIncreasingSubsequence().lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            /*            for (int k = 0; k < dp.length; k++) {
                System.out.printf(dp[k] + " ");
            }
            System.out.println();*/
            if(dp[i] > res) res = dp[i];
        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length]; // tails数组，初始化长度与nums相同
        int size = 0; // 有效长度，初始为0
        for (int x : nums) {
            int i = 0, j = size; // 使用二分查找在[0, size)范围内查找x的位置
            while (i != j) { // 当i不等于j时，说明范围未缩减到1
                int m = (i + j) / 2; // 取中间位置
                if (tails[m] < x) {
                    i = m + 1; // 如果中间位置的值小于x，说明x应该在右半边，调整i
                } else {
                    j = m; // 否则，x应该在左半边或就是m，调整j
                }
            }
            tails[i] = x; // 找到位置i，更新tails中的值
            if (i == size) ++size; // 如果i等于当前有效长度，有效长度+1
        }
        return size; // 返回有效长度，即为最长递增子序列的长度
    }
}
