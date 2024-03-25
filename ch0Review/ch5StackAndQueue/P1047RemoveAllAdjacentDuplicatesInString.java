package ch0Review.ch5StackAndQueue;

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
}
