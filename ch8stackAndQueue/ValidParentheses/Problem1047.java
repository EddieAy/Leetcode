package ch8stackAndQueue.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1047 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca"));
    }

    public static String removeDuplicates(String s) {
        if (s.length() == 1) return s;
        Deque<Character> st = new ArrayDeque<>();
        for (char c:s.toCharArray()) {
            if(!st.isEmpty()){
                if (c == st.peek()){
                    st.pop();
                }else {
                    st.push(c);
                }
            }else {
                st.push(c);
            }
        }

        if (st.isEmpty()){
            return "";
        }else {
            int size = st.size();
            char[] temp = new char[size];
            while (!st.isEmpty()){
                temp[size - 1] = st.pop();
                size--;
            }
            return new String(temp);
        }
    }

    public static String removeDuplicates2(String s){
        char[] chs = s.toCharArray();
        int top = -1;
        for (int i = 0; i < chs.length; i++) {
            if (top == -1 || chs[top] != chs[i]){
                top++;
                chs[top] = chs[i];
            }else {
                top--;
            }
        }

        return String.copyValueOf(chs,0,top + 1);
    }
}
