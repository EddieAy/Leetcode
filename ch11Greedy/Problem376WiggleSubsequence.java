package ch11Greedy;

public class Problem376WiggleSubsequence {
    /*
    * 6 -3 1 0
    *
    * */
    public static void main(String[] args) {
        System.out.println(new Problem376WiggleSubsequence().wiggleMaxLength3(new int[]{1,2,2,2,3,4}));
    }
    public int wiggleMaxLength2(int[] nums) {
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }

        int max = 0;
        int count = 0;
        for (int i = 0; i < diff.length - 1; i++) {
            if(diff[i] == 0){
                if(count > max){
                    max = count;
                    count = 0;
                }
            }else if(diff[i] > 0){
                if(diff[i + 1] < 0){
                    count++;
                    if(count > max){
                        max = count;
                    }
                }else if(diff[i + 1] > 0){
                    count = 0;
                }
            }else{
                if(diff[i + 1] > 0){
                    count++;
                    if(count > max){
                        max = count;
                    }
                }else if(diff[i + 1] < 0){
                    count = 0;
                }
            }
        }
        if(diff[diff.length - 1] >0 && diff[diff.length - 2] < 0 || (diff[diff.length - 1]  <0 && diff[diff.length - 2] > 0)){
            count++;
            if(count > max){
                max = count;
            }
        }
        return max + 1;
    }

    public int wiggleMaxLength(int[] nums){
        if(nums.length < 2){
            return nums.length;
        }
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up,down);
    }

    public int wiggleMaxLength3(int[] nums){
        if (nums.length <= 1) return nums.length;
        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;

            }
        }
        return result;
    }
}
