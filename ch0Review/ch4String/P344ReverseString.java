package ch0Review.ch4String;

public class P344ReverseString {

    public static void main(String[] args) {
        new P344ReverseString().reverseString(new char[]{'q','w','e'});
    }
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
