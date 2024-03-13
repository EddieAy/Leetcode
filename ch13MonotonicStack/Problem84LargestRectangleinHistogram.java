package ch13MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem84LargestRectangleinHistogram {

    public static void main(String[] args) {
        int[] a = {2,1,5,6,2,3};
        System.out.println(new Problem84LargestRectangleinHistogram().largestRectangleArea(a));
    }
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 1; i < newHeights.length - 1; i++) {
            newHeights[i] = heights[i - 1];
        }

        heights = newHeights;
        st.push(0);
        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            int num = heights[i];
            if(num > heights[st.peek()]){
                st.push(i);
            }else if(num == heights[st.peek()]){
                st.pop();
                st.push(i);
            }else {
                while (!st.isEmpty() && num < heights[st.peek()]){
                    int mid = st.pop();
                    int w = i - st.peek() - 1;
                    int h = heights[mid];
                    res = Math.max(res,w * h);
                }
                st.push(i);
            }
        }
        return res;
    }
}
