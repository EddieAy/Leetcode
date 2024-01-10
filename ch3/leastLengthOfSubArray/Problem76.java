package ch3.leastLengthOfSubArray;

import java.util.HashMap;

public class Problem76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }

    public static String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int i = 0,minI = 0;
        int j = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        HashMap<Character,Integer> window = new HashMap<>();
        for (int k = 0; k < t.length(); k++) {
            window.put(cht[k],window.getOrDefault(cht[k],0) + 1);
        }


        for(;j < s.length();j++){
            if(window.containsKey(chs[j])){
                if (window.get(chs[j]) > 0){
                    count--;
                }
                window.put(chs[j],window.get(chs[j]) - 1);
            }
            //当满足条件的时候，  如何满足条件    window size为0
            while (count == 0){
                if (j - i + 1 < minLen){
                    minLen = j - i + 1;
                    minI = i;
                }
                char temp = chs[i];
                if (window.containsKey(temp)){
                    window.put(temp,window.get(temp) + 1);

                    if (window.get(temp) > 0){
                        count++;
                    }
                }
                i++;
            }
            //更新结果
            // i不停++
        }
        return minLen == Integer.MAX_VALUE?"":new String(chs,minI,minLen);
    }
}
