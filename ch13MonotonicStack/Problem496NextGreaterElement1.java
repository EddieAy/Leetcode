package ch13MonotonicStack;

import java.util.*;

public class Problem496NextGreaterElement1 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,3,5,2,4};
        int[] a2 = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(new Problem496NextGreaterElement1().nextGreaterElement2(a1, a2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        int[] res = new int[nums2.length];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[st.peek()]){
                st.push(i);
            }else {
                while (!st.isEmpty() && nums2[i] > nums2[st.peek()]){//栈头 2,75        1  74   0，73   栈底
                    res[st.peek()] = i - st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }
        System.out.println(Arrays.toString(res));//1 1 0 0
        for (int i = 0; i < res.length; i++) {
            if(res[i] != 0){
                map.put(nums2[i],nums2[i + res[i]]);
            }else {
                map.put(nums2[i],-1);
            }
        }
        int[] res2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res2[i] = map.get(nums1[i]);
        }
        return res2;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2){
        Deque<Integer> st = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[i] > nums2[st.peek()]){//栈头 2,75        1  74   0，73   栈底
                map.put(nums2[st.peek()],nums2[i]);//res[st.peek()] = i - st.peek();[1,1,0,0]
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            map.put(nums2[st.pop()], -1);
        }
        int[] res2 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res2[i] = map.get(nums1[i]);
        }
        return res2;
    }
}
