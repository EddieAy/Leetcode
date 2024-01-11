package ch3.leastLengthOfSubArray;

public class Problem1004 {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(a,3));
    }

    public static int longestOnes(int[] nums, int k) {

        int i = 0, j = 0;
        int maxLen = 0;
        for (;j < nums.length;j++){
            if (nums[j] != 1){
                k--;
            }

            while (k < 0){
                if (nums[i] == 0){
                    k++;
                }
                i++;
            }
            maxLen = j - i + 1 > maxLen?j - i + 1:maxLen;
        }

        return maxLen;
    }
}
