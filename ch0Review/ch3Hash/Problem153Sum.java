package ch0Review.ch3Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length - 2;
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1,right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> ans = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(ans);
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }else if(sum < 0){
                    while (left < right && nums[left] == nums[++left]);
                }else {
                    while (left < right && nums[right] == nums[--right]);
                }
            }
        }
        return res;
    }
}
