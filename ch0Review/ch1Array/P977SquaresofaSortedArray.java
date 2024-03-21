package ch0Review.ch1Array;

public class P977SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0,right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = right;
        while (left <= right){
            if(Math.abs(nums[left]) <= Math.abs(nums[right])){
                res[index] = Math.abs(nums[right]) * Math.abs(nums[right]);
                right--;
            }else {
                res[index] = Math.abs(nums[left]) * Math.abs(nums[left]);
                left++;
            }
            index--;
        }
        return res;
    }
}
