package ch11Greedy;

public class Problem45JumpGameII {

    public static void main(String[] args) {
        System.out.println(new Problem45JumpGameII().jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] nums) {
        int step = 0;
        int start = 0;
        int end = 0;
        while (end < nums.length - 1){
            int maxPos = 0;
            for (int i = start; i <= end; i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            start = end + 1;
            end = maxPos;
            step++;
        }
        return step;
    }

    public int jump2(int[] nums) {
        int step = 0,end = 0,maxPos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(nums[i]+i, maxPos);
            if(i == end){
                end = maxPos;
                step++;
            }
        }
        return step;
    }
}
