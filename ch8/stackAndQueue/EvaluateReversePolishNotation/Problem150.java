package ch8.stackAndQueue.EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem150 {
    public static void main(String[] args) {
//        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] tokens = {"4","3","-"};

        System.out.println(evalRPN(tokens));

//        System.out.println(6 / -122);
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String s:tokens){
            if(isNumeric(s)){
                st.push(Integer.parseInt(s));
            }else {
                int right = st.pop();
                int left = st.pop();
                st.push(cal(right,left,s));
            }
        }
        return st.pop();
    }

    private static Integer cal(int right, int left, String s) {
        return switch (s) {
            case "+" -> right + left;
            case "-" -> left - right;
            case "*" -> right * left;
            default -> left / right;
        };
    }

    public static boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
