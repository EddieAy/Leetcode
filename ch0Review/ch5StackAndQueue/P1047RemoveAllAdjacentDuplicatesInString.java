package ch0Review.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        if(s.length() == 1) return s;
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append(chs[0]);
        for (int i = 1; i < s.length(); i++) {
            if(sb.length() > 0 && chs[i] == sb.charAt(sb.length() - 1)){
                sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(chs[i]);
            }
        }
        return new String(sb);
    }

    public String removeDuplicates2(String s){
        char[] chs = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            if(i == 0){
                st.push(chs[i]);
            }else {
                if(st.isEmpty()){
                    st.push(chs[i]);
                }else {
                    if(st.peek() == chs[i]) st.pop();
                    else st.push(chs[i]);
                }
            }
        }

        if(st.isEmpty()){
            return null;
        }else {
            char[] ans = new char[st.size()];
            for (int i = st.size() - 1; i >= 0 ; i--) {
                ans[i] = st.pop();
            }
            return new String(ans);
        }
    }

    public static void main(String[] args) {
        P1047RemoveAllAdjacentDuplicatesInString test = new P1047RemoveAllAdjacentDuplicatesInString();
        String s = test.removeDuplicates2("abbaca");
        System.out.println(s);

    }
}
