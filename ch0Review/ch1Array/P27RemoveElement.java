package ch0Review.ch1Array;

public class P27RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int fast = 0,slow = 0;
        for (fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
