package ch7String.ReverseString;

import java.util.Map;

public class Problem541 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }

    public static String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int len = s.length();
        int left = len % (2 * k);
        int i;
        for (i = 0; i < len; i+=(2 * k)) {
            reverseString(chs,i, Math.min(i + k,len));
        }

/*        if (left < k){
            reverseString(chs,len - left,len);
        }else if (left < 2 * k){
            reverseString(chs,len - left,len - left + k);
        }*/

        return new String(chs);
    }

    public static void reverseString(char[] s,int start,int end) {
        char temp = '1';
        int i = start,j = end - 1;
        while (i <= j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
