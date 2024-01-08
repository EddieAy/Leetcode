package ch2.removeElement;

public class Problem844 {
    public static void main(String[] args) {
//        System.out.println(backspaceCompare2("ab##","c#d#"));
        char[] s1 = {'a','b'};
        System.out.println(new String(s1,0,0));
    }

    public static boolean backspaceCompare(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        int i = s.length() - 1;
        int j = t.length() - 1;
        int skipS = 0,skipT = 0;

        while(i >= 0 || j >= 0){
            while (i >= 0){
                if (s.charAt(i) == '#'){    //遇到了#
                    skipS++;
                    i--;
                }else if (skipS > 0){       //没遇到# 遇到正常符号 但是应该跳过
                    skipS--;
                    i--;
                }else {     //没遇到# 遇到正常符号 无需跳过
                    break;
                }
            }

            while (j >= 0){
                if (t.charAt(j) == '#'){    //遇到了#
                    skipT++;
                    j--;
                }else if (skipT > 0){       //没遇到# 遇到正常符号 但是应该跳过
                    skipT--;
                    j--;
                }else {     //没遇到# 遇到正常符号 无需跳过
                    break;
                }
            }

            if ((i>=0) != (j>=0)){
                return false;
            }

            if (i >=0 && j>=0 && s.charAt(i) != t.charAt(j)){
                return false;
            }
            i--;
            j--;

            // ab##  cqe
        }
        return true;
    }

    public static boolean backspaceCompare2(String s, String t){
        return backString(s.toCharArray()).equals(backString(t.toCharArray()));
    }

    public static String backString(char[] s1){
        int slowIndex = 0;
        for (int fastIndex = 0;fastIndex < s1.length;fastIndex++){
            if (s1[fastIndex] != '#'){
                s1[slowIndex++] = s1[fastIndex];
            }else if(slowIndex > 0){
                slowIndex--;
            }
        }
        return new String(s1,0,slowIndex);
    }
}
