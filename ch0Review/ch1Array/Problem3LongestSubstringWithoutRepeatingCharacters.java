package ch0Review.ch1Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        char[] chs = s.toCharArray();
        int i = 0,res = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < chs.length; j++) {
            while (set.contains(chs[j])){
                set.remove(chs[i]);
                i++;
            }
            set.add(chs[j]);
            res = Math.max(res,j - i + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s){
        Map<Character,Integer> map = new HashMap<>();
        int i = 0,res = 0,len = s.length();
        for (int j = 0; j < len; j++) {
            if(map.containsKey(s.charAt(j))){
               if(map.get(s.charAt(j)) <= j && map.get(s.charAt(j)) >= i){
                   i = map.get(s.charAt(j)) + 1;
               }else if(map.get(s.charAt(j)) < i){
                   i = i;
               }
            }
            map.put(s.charAt(j),j);
            res = Math.max(res,j - i + 1);
        }
        return res;
    }
}
