package ch3leastLengthOfSubArray;

public class Problem209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen1(7,new int[] {2,3,1,2,4,3}));
    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int sum;
        int len;
        int minLen = (int)Math.pow(10,5) + 1;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            len = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                len++;
                if(sum >= target){
                    break;
                }
            }
            if (i == 0 && sum < target){
                minLen = 0;
                break;
            }
            if (sum >= target){
                if (len < minLen){
                    minLen = len;
                }
            }

        }
        return minLen;
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int len = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (; j < nums.length; j++) {
            sum+=nums[j];
            while (sum >= target){
                len = j - i + 1;
                result = result <= len ? result:len;
                sum-=nums[i++];
            }
        }

        return result == Integer.MAX_VALUE?0:result;
    }
}
