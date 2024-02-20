package ch11Greedy;

public class Problem53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            if(count > max){
                max = count;
            }
            if (count <= 0) count=0;
        }
        return max;
    }
}
