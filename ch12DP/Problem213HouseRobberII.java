package ch12DP;

public class Problem213HouseRobberII {
    public int rob(int[] nums) {
        /*
        * 分两次偷 第一次不偷第一个房子 第二次不偷最后一个房子
        * 然后比较大小
        *
        * */
        if(nums.length == 1 ) return nums[0];
        int len = nums.length;
        int[] dp1 = new int[len + 1];
        dp1[0] = 0;
        //不偷第一个
        dp1[1] = 0;
        for (int i = 2; i <= len ; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i - 1],dp1[i - 1]);
        }
        int[] dp2 = new int[len + 1];
        dp2[0] = 0;
        //不偷最后一个
        dp2[1] = nums[0];
        for (int i = 2; i <= len ; i++) {
            if(i != len){
                dp2[i] = Math.max(dp2[i - 2] + nums[i - 1],dp2[i - 1]);
            }else {
                dp2[i] = Math.max(dp2[i - 2],dp2[i - 1]);
            }
        }
        return Math.max(dp1[len],dp2[len]);
    }
}
