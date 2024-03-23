package ch0Review.ch3Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P350IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums1){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num:nums2){
            if(map.containsKey(num)){
                map.put(num,map.get(num) - 1);
                res[index++] = num;
                if(map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOf(res, index);
    }
}
