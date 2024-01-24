package ch7.String.KMP;

public class Problem459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        //  a  bababa   b
    }

    public static boolean repeatedSubstringPattern(String s) {
        String news = s + s;

        return news.substring(1,2 * s.length() - 1).contains(s);

    }

    public static boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n ; i++) {
            if (n % i == 0){
                boolean flag = true;
                for (int j = i; j < n; j++) {
                    if(s.charAt(j) != s.charAt(j - i)){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    return true;
                }
            }
        }

        return false;

    }
}

//abcabcabc  bc abc abc abc abc ab
//abcabcabe  bc abc abe abc abc ab