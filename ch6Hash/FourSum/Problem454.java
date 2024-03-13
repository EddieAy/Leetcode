package ch6Hash.FourSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Problem454 {
    public static void main(String[] args) {

    }

    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, List<Integer>> map1 = new HashMap<>();
        HashMap<Integer, List<Integer>> map2 = new HashMap<>();
        HashMap<Integer, List<Integer>> map3 = new HashMap<>();
        HashMap<Integer, List<Integer>> map4 = new HashMap<>();
        HashSet<List<Integer>> set = new HashSet<>();
        int target = 0;

        for (int i = 0; i < nums1.length; i++) {
            getHash(map1, nums1[i], i);
            getHash(map2, nums2[i], i);
            getHash(map3, nums3[i], i);
            getHash(map4, nums4[i], i);
        }

        for (Integer i1 : nums1) {
            for (Integer i2 : nums2) {
                for (Integer i3 : nums3) {
                    for (Integer i4 : nums4) {
                        if (map4.containsKey(target - i1 - i2 - i3)) {
                            int[] temp = new int[]{map1.get(i1).getFirst()};
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void getHash(HashMap<Integer, List<Integer>> map, int nums, int index) {
        if (!map.containsKey(nums)) {
            map.put(nums, new ArrayList<>());
        }
        map.get(nums).add(index);
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int k : nums3) {
            for (int l : nums4) {
                count += map.getOrDefault(-(k + l), 0);
            }
        }

        return count;
    }
}
