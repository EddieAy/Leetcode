package ch6.Hash.IntersectionofTwoArrays;

import java.util.*;

public class Problem349 {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums1){
            set.add(num);
        }
        Set<Integer> li = new HashSet<>();
        for (int num2:nums2){
            if(set.contains(num2)){
                li.add(num2);
            }
        }

        return li.stream().mapToInt(i -> i).toArray();
    }
}
