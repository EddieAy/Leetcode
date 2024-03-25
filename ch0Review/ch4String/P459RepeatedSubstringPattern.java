package ch0Review.ch4String;

public class P459RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String Ans = s + s;
        return Ans.substring(1,2 * s.length() - 1).contains(s);
    }

    public boolean repeatedSubstringPattern2(String s) {
        if(s.isEmpty()) return false;

        int[] next = getNext(s);
        boolean flag1 = (next[s.length() - 1] != 0);
        boolean flag2 = (s.length() % (s.length() - next[s.length() - 1]) == 0);
        if(flag1 && flag2){
            return true;
        }
        return false;
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        char[] chs = s.toCharArray();
        next[0] = 0;
        int i = 1;
        int prefix = 0;
        while (i < next.length){
            if(chs[i] == chs[prefix]){
                prefix++;
                next[i] = prefix;
                i++;
            }else {
                if(prefix == 0){
                    next[i] = 0;
                    i++;
                }else {
                    prefix = next[prefix - 1];
                }
            }
        }
        return next;
    }
}
