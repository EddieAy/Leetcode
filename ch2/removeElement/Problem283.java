package ch2.removeElement;

public class Problem283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};//1,0,3,12

        //solution 1
        int fastIndex = 0;
        int slowIndex = 0;
        for (; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != 0){
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        for (int i = slowIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        //两个指针i和j solution2
//        int j = 0;
//        for(int i=0;i<nums.length;i++) {
//            //当前元素!=0，就把其交换到左边，等于0的交换到右边
//            //num[i] == 0 的话 j是不变的      j永远在第一个为0的地方
//            //num[i] != 0 的话
//            if(nums[i]!=0) {
//                int tmp = nums[i];
//                nums[i] = nums[j];
//                nums[j++] = tmp;
//            }
//        }

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ",nums[i]);
        }
    }

    public void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

}
