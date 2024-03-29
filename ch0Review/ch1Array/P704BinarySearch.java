package ch0Review.ch1Array;

public class P704BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (right - left) / 2 + left;
            int num = nums[mid];
            if(num == target){
                return mid;
            }else if(num > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
