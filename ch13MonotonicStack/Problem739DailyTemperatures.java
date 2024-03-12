package ch13MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        if( len == 1 ) return new int[]{0};
        int[] res = new int[len];

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len ; j++) {
                if(temperatures[j] > temperatures[i]){
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
//        if(temperatures.length == 1) return new int[]{0};
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
//        st.push(temperatures[0]);
        st.push(0);
        int num;
        for (int i = 1; i < temperatures.length; i++) {
//            num = temperatures[i];
            num = i;
            if(temperatures[num] < temperatures[st.peek()]){
                st.push(num);
            }else if(temperatures[num] == temperatures[st.peek()]){
                st.push(num);
            }else {
                while (!st.isEmpty()&& temperatures[num] > temperatures[st.peek()]){//    栈头 2,75        1  74   0，73   栈底
                    res[st.peek()] = num - st.peek();// 1 - 0
                    st.pop();
                }
                st.push(num);
            }
        }
        return res;
    }

    public int[] dailyTemperatures3(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        st.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if(temperatures[i] < temperatures[st.peek()]){
                st.push(i);
            }else if(temperatures[i] == temperatures[st.peek()]){
                st.push(i);
            }else {
                while (!st.isEmpty()&& temperatures[i] > temperatures[st.peek()]){//    栈头 2,75        1  74   0，73   栈底
                    res[st.peek()] = i - st.peek();// 1 - 0
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }
}
