package ch2removeElement;

public class Problem977 {
    public static void main(String[] args) {
        int[] a = sortedSquares(new int[] {-4,-1,0,3,10});

    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        int[] ans = new int[nums.length];
        while (left <= right){
            if (  Math.abs(nums[left]) <= Math.abs(nums[right]) ) {
                ans[index] = nums[right] * nums[right];
                right--;
            } else {
                ans[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return ans;
    }
}
