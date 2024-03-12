package ch13MonotonicStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem503NextGreaterElement2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem503NextGreaterElement2().nextGreaterElements2(new int[]{5, 4, 3, 2, 1})));
    }
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[nums.length];
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!st.isEmpty() && num > nums[st.peek()]){
                res[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if(res[i] != 0){
                ans[i] = nums[i + res[i]];
            }else {
                ans[i] = -1;
            }
        }
        int target = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > target){
                ans[nums.length - 1] = nums[i];
                break;
            }else {
                ans[nums.length - 1] = -1;
            }
        }
        return ans;
    }

    public int[] nextGreaterElements2(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]){
                ans[stack.pop()] = num;
            }
            if(i < n){
                stack.push(i);
            }
        }
        return ans;
    }
}
