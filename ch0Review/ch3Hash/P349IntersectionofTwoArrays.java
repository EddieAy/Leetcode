package ch0Review.ch3Hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P349IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int num1:nums1){
            set.add(num1);
        }
        for (int num2:nums2){
            if(set.contains(num2)){
                res.add(num2);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (Integer num:res){
            ans[i++] = num;
        }
        return ans;
    }
}
