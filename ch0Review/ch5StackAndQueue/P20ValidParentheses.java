package ch0Review.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20ValidParentheses {
    public boolean isValid(String s) {
        char[] chs = s.toCharArray();
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] == '('){
                st.push(')');
            }else if(chs[i] == '['){
                st.push(']');
            }else if(chs[i] == '{'){
                st.push('}');
            }else{
                if(st.isEmpty()) return false;
                else {
                    if(st.peek() != chs[i]) return false;
                    else st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
