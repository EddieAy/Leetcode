package ch12DP;

public class Problem718MaximumLengthofRepeatedSubarray {

    public static void main(String[] args) {
        int[] a1 = {1,2,3,2,1};
        int[] a2 = {3,2,1,4,7};
        System.out.println(new Problem718MaximumLengthofRepeatedSubarray().findLength2(a1,a2));
    }
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[nums1. length + 1][nums2.length + 1];

        int res = 0;
        for (int i = 1; i <=  len1; i++) {
            for (int j = 1; j <= len2 ; j++) {
                if(nums1[i - 1] == nums2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if(dp[i][j] > res) res = dp[i][j];
            }
        }
        return res;
    }

    public int findLength2(int[] nums1, int[] nums2) {
        int maxLength = 0; // 用于记录最长公共子数组的长度
        // 外层循环遍历nums1
        for (int i = 0; i < nums1.length; i++) {
            // 内层循环遍历nums2
            for (int j = 0; j < nums2.length; j++) {
                // 当前公共子数组的长度
                int length = 0;
                // 当前比较的索引在两个数组中的位置
                int index1 = i;
                int index2 = j;
                // 当索引未超出任一数组范围且对应元素相等时，继续遍历
                while (index1 < nums1.length && index2 < nums2.length && nums1[index1] == nums2[index2]) {
                    length++; // 增加当前公共子数组的长度
                    index1++; // 移动nums1的索引
                    index2++; // 移动nums2的索引
                }
                // 如果当前公共子数组的长度大于已记录的最长长度，则更新最长长度
                maxLength = Math.max(maxLength, length);
            }
        }
        // 返回记录的最长公共子数组的长度
        return maxLength;
    }
}
