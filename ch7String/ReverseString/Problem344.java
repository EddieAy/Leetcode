package ch7String.ReverseString;

public class Problem344 {
    public static void main(String[] args) {


    }

    public void reverseString(char[] s) {
        char temp = '1';
        int i = 0,j = s.length - 1;
        while (i <= j){
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
