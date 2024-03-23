package ch0Review.ch3Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P438FindAllAnagramsinaString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lenP = p.length();
        int lenS = s.length();
        if(lenP > lenS) return res;
        for (int i = 0; i < lenS - lenP + 1; i++) {
            String temp = s.substring(i,i + lenP);
            char[] chs = temp.toCharArray();
            Arrays.sort(chs);
            String ans = new String(chs);
            if(ans.equals(p)){
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams2(String s, String p){
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null || s.length() < p.length()) return res;
        int[] maps = new int[26];
        int[] mapp = new int[26];
        for (char c:p.toCharArray()){
            mapp[c - 'a']++;
        }
        int left = 0,right = 0;
        while (right < s.length()){
            maps[s.charAt(right) - 'a']++;

            if(right - left + 1 == p.length()){
                if(Arrays.equals(mapp,maps)){
                    res.add(left);
                }
                maps[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return res;
    }
}
