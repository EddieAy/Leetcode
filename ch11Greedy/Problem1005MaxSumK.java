package ch11Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem1005MaxSumK {

    public static void main(String[] args) {
        System.out.println(new Problem1005MaxSumK().largestSumAfterKNegations3(new int[]{-4,-2,-3},4));
    }

    public int largestSumAfterKNegations114(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] == 0){
            return Arrays.stream(nums).sum();
        }else if(nums[0] > 0){
            if(k % 2 == 0){
                return Arrays.stream(nums).sum();
            }else {
                return Arrays.stream(nums).sum() - 2 * nums[0];
            }
        }else if(nums[nums.length - 1] < 0){
            System.out.println("???");
        } else {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > 0){
                    index = i;      //index = 2   0 1是负数
                    break;
                }
            }
            if(k == index){
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    if(i < index){
                        sum +=  (nums[i] * -1);
                    }else {
                        sum +=nums[i];
                    }
                }
                return sum;
            }else if(k > index){
                int diff = k - index;// 2  5
                if (diff % 2 == 0){
                    int sum = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if(i < index){
                            sum +=  (nums[i] * -1);
                        }else {
                            sum +=nums[i];
                        }
                    }
                    return sum;
                }else {
                    int sum = 0;
                    for (int i = 0; i < nums.length; i++) {
                        if(i < index){
                            sum +=  (nums[i] * -1);
                        }else {
                            sum +=nums[i];
                        }
                    }
                    if(Math.abs(nums[index - 1]) >= nums[index]){
                        return sum - 2 * nums[index];// -3  1{
                    }else {
                        return sum + 2 * nums[index - 1];
                    }
                }
            }else {//k < index  -4 -3 -2 -1   2
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    if(i < k){
                        sum +=  (nums[i] * -1);
                    }else {
                        sum +=nums[i];
                    }
                }
                return sum;
            }
        }
        return 1;
    }

    public int largestSumAfterKNegations(int[] nums, int k){
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }

        Arrays.sort(nums1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        /*
        * //k还剩  负数不多 全正了
        * k全用光了 k = 0
        * */
        for (int i = 0; i < nums1.length; i++) {
            if(nums1[i] < 0 && k >0){
                nums1[i] = -nums1[i];
                k--;
            }
        }
        if(k % 2 == 1){
            nums1[nums1.length - 1] *= -1;
        }
        int sum = 0;
        for (int b:nums1){
            sum +=b;
        }
        return sum;
    }

    public int largestSumAfterKNegations3(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k还有盈余，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -1 * nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        // 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
    }
}
