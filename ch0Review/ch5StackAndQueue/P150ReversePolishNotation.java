package ch0Review.ch5StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class P150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            if(isNumeric(tokens[i])){
                st.push(Integer.parseInt(tokens[i]));
            }else {
                int right = st.pop();
                int left = st.pop();
                switch (tokens[i]){
                    case "+":
                        st.push(left + right);
                        break;
                    case "-":
                        st.push(left - right);
                        break;

                    case "*":
                        st.push(left * right);
                        break;
                    case "/":
                        st.push(left / right);
                        break;
                }
            }
        }
        return st.pop();
    }

    private boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
