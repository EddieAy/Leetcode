package ch0Review.ch3Hash;

import java.util.HashMap;
import java.util.Map;

public class P4544SumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num1:nums1){
            for (int num2:nums2){
                int sum = num1 + num2;
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        // 1 + 2 + () + () = 0
        int res = 0;
        for (int num3:nums3){
            for (int num4:nums4){
                int cnt = map.getOrDefault(0 - num3 - num4,0);
                res += cnt;
            }
        }
        return res;
    }
}
