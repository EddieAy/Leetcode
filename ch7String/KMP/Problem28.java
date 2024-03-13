package ch7String.KMP;

public class Problem28 {
    public static void main(String[] args) {
        System.out.println(strStr("leetcodecodco","ABCDEFABCDEFQW"));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int[] next = getNext(needle);//[0, 0, 0, 1, 2,3,4,1,2]
        while (i < haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else if (j > 0) {
                j = next[j - 1];
            }else {
                i++;
            }

            if (j == needle.length()){
                return i - j;
            }
        }

        return -1;
    }
//    这里可以在建一一个新的数组方便理解，就是把最后一个位置的B放到C的位置上，形成ABAB的数组序列，而在ABAB的数组中第2个A的next是1,此时可以继续比对
    private static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int k = 0;
        int i = 1;
        while (i < needle.length()){
            if (needle.charAt(i) == needle.charAt(k)){
                k++;
                next[i] = k;
                i+=1;
            }else {
                if (k == 0){
                    next[i] = 0;
                    i++;
                }else {
                    k = next[k - 1];
                }
            }
        }
        return next;
    }

/*    public static void setNext(char[] ch,int[] next){
        int len = ch.length;
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            int k = next[i - 1];
            while (ch[i] != ch[k] && k != 0){
                k = next[k - 1];        //不对称的时候 我的最长相等 为   next[3 - 1]
            }
            if (ch[i] == ch[k]){
                next[i] = k + 1;
            }else {
                next[i] = 0;
            }
        }
    }

    public static int[] buildNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0; // next array starts with a 0
        int prefixLen = 0; // the length of the previous longest prefix
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(prefixLen) == pattern.charAt(i)) {       //AA 走这里
                prefixLen++;
                next[i] = prefixLen;
                i++;
            } else {
                if (prefixLen == 0) {       //AB 走这里
                    next[i] = 0;
                    i++;
                } else {                    //ABA
                    prefixLen = next[prefixLen - 1];
                }
            }
        }
        return next;
    }*/
}
