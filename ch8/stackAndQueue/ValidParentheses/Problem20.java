package ch8.stackAndQueue.ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Problem20 {
    public static void main(String[] args) {
        System.out.println(isValid("[()]"));
    }

    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> st = new ArrayDeque<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        for (char c:s.toCharArray()){
/*            if (c == '('){
                st.push(')');
            }else if(c == '['){
                st.push(']');
            }else if (c == '{'){
                st.push('}');
            }*/
            if(map.containsKey(c)){
                st.push(map.get(c));
            }else if(st.isEmpty() || st.peek()!= c){
                return false;
            }else {
                st.pop();
            }
        }

        return st.isEmpty();
    }
    public static boolean isValid(String s) {
        if (s.charAt(0) == ']' || s.charAt(0) == ')'||s.charAt(0) == '}') return false;
        Deque<Character> st = new ArrayDeque<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char tempc = s.charAt(i);
            if (tempc == '(' || tempc == '['||tempc == '{'){
                st.push(tempc);
            }else {
                boolean flag = judge(st,tempc);
                if(!flag){
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    public static boolean judge(Deque<Character> st,char c){
        char ans = 0;
        if(c == ']'){
            ans = '[';
        }else if (c == ')'){
            ans = '(';
        }else if (c == '}'){
            ans = '{';
        }

        if(st.isEmpty()) {
            return false;
        } else {
            char temp = st.pop();
            return temp == ans;
        }
    }

}
