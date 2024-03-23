package ch0Review.ch3Hash;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
//        }
        for (int i = 0; i < nums.length - 1; i++) {
            map.put(nums[i],i);
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        return null;
    }
}
