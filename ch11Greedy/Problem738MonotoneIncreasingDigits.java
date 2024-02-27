package ch11Greedy;

public class Problem738MonotoneIncreasingDigits {

    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(86432));
    }
    public int monotoneIncreasingDigits2(int n) {
        while (!isValid(n)){
            n--;
        }
        return n;
    }

    public static boolean isValid(int n){
        if (n == 0) return true;
        int length = (n == 0) ? 1 : (int)(Math.log10(n) + 1);
        int[] digits = new int[length];
        int temp = n,temp1;
        while (n > 0){
            temp1 = n % 10;
            n /= 10;
            digits[--length] = temp1;
        }
        for (int i = 0; i < digits.length - 1; i++) {
            if(digits[i] > digits[i + 1]) return false;
        }
        return true;
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int length = digits.length;
        for (int i = length - 1 ; i > 0 ; i--) {
            if(digits[i] < digits[i - 1]){
                length = i;
                digits[i - 1]--;
            }
        }
        for (int i = length; i < digits.length; i++) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }
}
