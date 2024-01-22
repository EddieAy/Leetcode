package ch7.String.ReverseWordsinaString;

import java.util.ArrayList;
import java.util.List;

public class Problem151 {
    public static void main(String[] args) {
        char[] chars= new char[]{' ','2'};

    }

    public static String reverseWords2(String s) {
        s = s.trim();
        int j = s.length() - 1;
        int i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0){
            while (i >=0 && s.charAt(i)!=' ') i--;
            sb.append(s.substring(i + 1,j + 1) + " ");
            while (i >=0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        return sb.toString().trim();
    }

    public static String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseString(sb,0,sb.length()-1);
        reverseEachWord(sb);
        return sb.toString();
    }

    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length() - 1;
        while (start < n){
            while (end < n && sb.charAt(end) != ' ') end++;
            reverseString(sb,start,end - 1);
            start++;
            end = start + 1;
        }
    }

    private static void reverseString(StringBuilder sb, int i, int i1) {
        while (i < i1){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i1));
            sb.setCharAt(i1,temp);
            i++;
            i1--;
        }
    }

    public static StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start)!=' ') start++;
        while (s.charAt(end)!=' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end){
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start++;
        }
        return sb;
    }
}
