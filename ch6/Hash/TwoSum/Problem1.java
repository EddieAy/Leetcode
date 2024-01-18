package ch6.Hash.TwoSum;

import java.util.*;

public class Problem1 {
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] nums2 = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            } else {
                if(nums[left] + nums[right] > target){
                    right--;
                }else {
                    left++;
                }
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < nums2.length; i++) {
            if (nums[left] == nums2[i]){
                ans[0] = i;
                break;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums[right] == nums2[i] && ans[0] != i){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        /*
        * 对于target
        * */
        for (Integer i:map.keySet()){
            if (target != i * 2){
                if (map.containsKey(target - i)){
                    ans[0] = map.get(i).getFirst();
                    ans[1] = map.get(target - i).getFirst();
                    return ans;
                }
            }else {
                if (map.containsKey(i) && map.get(i).size() != 1){
                    ans[0] = map.get(i).getFirst();
                    ans[1] = map.get(i).getLast();
                    return ans;
                }
            }
        }
        return new int[] {-1,-1};
    }

    public int[] twoSum3(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[] {i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}