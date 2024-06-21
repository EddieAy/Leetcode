package ch0Review.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P239SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for(int i = k ; i < nums.length;i++){
            if(deque.peekFirst() == nums[i - k]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
