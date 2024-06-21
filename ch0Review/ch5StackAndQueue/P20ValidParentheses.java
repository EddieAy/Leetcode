package ch0Review.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20ValidParentheses {

    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < charArray.length; i++) {
            char chs = charArray[i];
            if (chs == '(' || chs == '[' || chs == '{'){
                deque.push(chs);
            }else {
                if(deque.isEmpty()){
                    return false;
                }else {
                    char pop = deque.pop();
                    if(chs == ')' && pop == '(' || (chs == ']' && pop == '[') || (chs == '}' && pop == '{') ){
                        continue;
                    }else {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();

    }
    public boolean isValid2(String s) {
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
