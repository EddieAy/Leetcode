package ch0Review.ch3Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P184Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if(nums[i] > 0 && nums[i] > target) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1,right = nums.length - 1;
                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        res.add(ans);
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                    }else if(sum < target){
                        while (left < right && nums[left] == nums[++left]);
                    }else {
                        while (left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return res;

    }
}
