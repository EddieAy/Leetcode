package ch7.String;

public class rightRotateString {
    public static void main(String[] args) {
        System.out.println(rightRotate("abcdefg",2));
    }

    private static String rightRotate(String s, int i) {
//        StringBuilder sb = new StringBuilder(s);
        s = reseverseString(s.toCharArray(),0,s.length() - 1);
        String s2 = s.substring(0,i);
        s2 = reseverseString(s2.toCharArray(),0,s2.length() - 1);
        String s3 = s.substring(i);
        s3 = reseverseString(s3.toCharArray(),0,s3.length() - 1);

        return s2 + s3;
    }

    public static String reseverseString(char[] chs,int start,int end){
        while (start < end){
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }

        return new String(chs);
    }
}
