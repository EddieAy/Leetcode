package ch0Review.ch4String;

public class P541ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int len = chs.length;
        int mod = len % (2 * k);
        for (int i = 0; i < len; i+=(2 * k)) {
            reverseString(chs,i,Math.min(i + k,len));
        }
        return new String(chs);
    }

    public void reverseString(char[] s,int left,int right) {
        right--;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
