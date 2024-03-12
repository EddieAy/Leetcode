package ch13MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem42TrappingRainWater {
    public int trap(int[] height) {
        if(height.length <= 2){
            return 0;
        }
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            if(height[i] < height[st.peek()]){
                st.push(i);
            }else if(height[i] == height[st.peek()]){
                st.pop();
                st.push(i);
            }else {
                while (!st.isEmpty() && height[i] > height[st.peek()]){
                    int mid = st.pop();
                    if(!st.isEmpty()){
                        int h = Math.min(height[st.peek()],height[i]) - height[mid];
                        int w = i - st.peek() - 1;
                        sum += h * w;
                    }
                }
                st.push(i);
            }
        }
        return sum;
    }
}
