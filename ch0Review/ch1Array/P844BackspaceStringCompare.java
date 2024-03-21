package ch0Review.ch1Array;

import java.util.ArrayDeque;
import java.util.Deque;

public class P844BackspaceStringCompare {

    public static void main(String[] args) {
        boolean flag = new P844BackspaceStringCompare().backspaceCompare("a#c","b");
    }
    public boolean backspaceCompare(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Deque<Character> stackS = new ArrayDeque<>();
        Deque<Character> stackT = new ArrayDeque<>();
        for (int i = 0; i < chs.length; i++) {
            if(chs[i] != '#'){
                stackS.push(chs[i]);
            }else {
                if(!stackS.isEmpty()){
                    stackS.pop();
                }
            }
        }
        for (int i = 0; i < cht.length; i++) {
            if(cht[i] != '#'){
                stackT.push(cht[i]);
            }else {
                if(!stackT.isEmpty()){
                    stackT.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stackT) {
            sb.append(c);
        }
        String result = sb.toString();

        StringBuilder sb1 = new StringBuilder();
        for (Character c : stackS) {
            sb1.append(c);
        }
        String result1 = sb1.toString();

        System.out.println(result1+" "+result);
        return result.equals(result1);

    }

    public boolean backspaceCompare2(String s, String t){
        String s1 = backString(s.toCharArray());
        String s2 = backString(t.toCharArray());
        return s1.equals(s2);
    }

    private String backString(char[] charArray) {
        int slow = 0;
        for (int fast = 0; fast < charArray.length; fast++) {
            if(charArray[fast] != '#'){
                charArray[slow++] = charArray[fast];
            }else if(slow > 0){
                slow--;
            }
        }
        return new String(charArray,0,slow);
    }
}
