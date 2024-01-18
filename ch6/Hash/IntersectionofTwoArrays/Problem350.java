package ch6.Hash.IntersectionofTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem350 {
    public static void main(String[] args) {

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> li = new ArrayList<>();
        for (int num2 : nums2) {
            if (map.containsKey(num2)) {
                map.put(num2, map.get(num2) - 1);
                li.add(num2);
                if (map.get(num2) == 0) {
                    map.remove(num2);
                }
            }
        }

        return li.stream().mapToInt(i -> i).toArray();
    }
}
