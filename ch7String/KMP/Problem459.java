package ch7String.KMP;

public class Problem459 {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern3("abab"));
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

    public static boolean repeatedSubstringPattern3(String s){
        if (s.isEmpty()) return false;

        int[] next = getNext(s);
        int len = next.length;
        if (next[len - 1] != 0 && (len % (len - next[len - 1]) == 0)){
            return true;
        }
        return false;
    }

    private static int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int i = 1;
        int k = 0;
        int len = s.length();
        while (i < len){
            if (s.charAt(i) == s.charAt(k)){
                k++;
                next[i] = k;
                i++;
            }else {
                if(k == 0){
                    next[i] = 0;
                    i++;
                }else {
                    k = next[k - 1];
                }
            }
        }
        return next;
    }
}

