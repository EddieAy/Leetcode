package ch0Review.ch1Array;

public class P34FindFirstAndLast {

    public static void main(String[] args) {
        int[] ints = new P34FindFirstAndLast().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
    public int[] searchRange(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        int mid = 0;
        boolean flag = false;
        while (left <= right){
            mid = (right - left) / 2 + left;
            int num = nums[mid];
            if(target == num){
                flag = true;
                break;
            }else if(target > num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        if(!flag){
            return new int[]{-1,-1};
        }
        int index = mid;
        while (index >= 0 && nums[index] == target){
            index--;
        }
        int index2 = mid;
        while (index2 <= nums.length - 1 && nums[index2] == target){
            index2++;
        }
        return new int[]{++index,--index2};
    }

    public int[] searchRange2(int[] nums, int target){
        int left = 0,right = nums.length - 1;
        int mid;
        int first = -1;
        int last = -1;
        while (left <= right){
            mid = (right - left) / 2 + left;
            int num = nums[mid];
            if(target == num){
                last = mid;
                left = mid + 1;
            }else if(target > num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length - 1;

        while (left <= right){
            mid = (right - left) / 2 + left;
            int num = nums[mid];
            if(target == num){
                first = mid;
                right = mid - 1;
            }else if(target > num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return new int[]{first,last};
    }
}
