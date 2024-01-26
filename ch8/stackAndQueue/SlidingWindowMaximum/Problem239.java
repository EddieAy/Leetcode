package ch8.stackAndQueue.SlidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Problem239 {
    public static void main(String[] args) {
        int[] a = {1,3,-1,-3,5,3,6,7};
        int[] b = maxSlidingWindow(a,3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int [] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }
}
