package ch2.removeElement;

public class Problem26 {
    public static void main(String[] args) {
        // 1 1 2 2 3 3
        // 1 2
        // 0,0,1,1,1,2,2,3,3,4
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));


    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return 1;
        }
        int slowIndex = 1;
        int fastIndex = 1;
        int length = nums.length;
        for (; fastIndex < length; fastIndex++) {
            if (nums[fastIndex] != nums[fastIndex-1]){  //0
                nums[slowIndex++] = nums[fastIndex];
            }

        }

        return slowIndex;

    }
}
