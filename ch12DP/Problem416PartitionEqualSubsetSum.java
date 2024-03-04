package ch12DP;

public class Problem416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] a = {1,5,11,5};
        System.out.println(new Problem416PartitionEqualSubsetSum().canPartition(a));
    }

    /*
     * 为什么要取最大值 不应该把计算出来的值 都和目标值比较？？
     * 其实我感觉这里是利用了容量为sum/2能背的最大重量和(最大和)是小于或者等于sum/2这个特点(最大就是等于sum/2)，
     * 所以照着01背包的流程来解这个题目。比如数组是【1, 5】，那么容量为(1+5)/2 = 3的背包最多能背的重量和是1，对应题目也就是不能分成相等的两堆。
     * 如果数组是【1, 2, 3】，那么容量为(1 + 2+ 3) /2的背包最多能背的重量和就是3，等于sum/2，对应的也就是能够分成相等的两堆。
     *
     * 一开始我也不明白，为啥可以利用容量sum/2能背的最大的价值就是 sum/2呢？
     * 是因为价值和重量是一样的，都是一个单位，也就是说尽可能的装物品，在容量sum/2的前提下，看下其总价值是否等于 sum/2 = target.
     * */
    public boolean canPartition(int[] nums) {
        int[] dp = new int[20000];
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        if(sum % 2 == 1) return false;
        int target = sum / 2;

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
            if(dp[target] == target) return true;
        }
        return false;
    }
}
