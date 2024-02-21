package ch11Greedy;

public class Problem55JumpGame {

    public static void main(String[] args) {
        System.out.println(new Problem55JumpGame().canJump(new int[]{0,2,3}));
    }
    public boolean canJump2(int[] nums) {
        if(nums.length == 1){
            if(nums[0] == 0){
                return false;
            }else {
                return true;
            }
        }
        int distance = 2;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] != 0){
                if(nums[i] < distance){
                    distance++;
                    continue;
                }else {
                    return true;
                }
            }
            distance++;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int cover = 0;
        if(nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i,cover);
            if(cover >= nums.length - 1) return true;
        }
        return false;
    }
}
