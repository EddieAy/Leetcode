package ch0Review.ch1Array;

public class P209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int subLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum+=nums[j];
            while (sum >= target){
                subLength = j - i + 1;
                res = Math.min(res, subLength);
                sum-=nums[i];
                i++;
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }
}
