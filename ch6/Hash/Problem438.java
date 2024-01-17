package ch6.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。*/
public class Problem438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ll = findAnagrams2(s,p);
        for (Integer i:ll){
            System.out.println(i);
        }
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        char[] chs = s.toCharArray();

        char[] chp = p.toCharArray();
        Arrays.sort(chp);
        String sortedP = new String(chp);
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i <= s.length() - len; i++) {
            char[] ch = Arrays.copyOfRange(chs,i,i+len);
            Arrays.sort(ch);
            String sortedStr = new String(ch);
            if (sortedStr.equals(sortedP)){
                ll.add(i);
            }
        }
        return ll;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        int[] maps = new int[26];
        int[] mapp = new int[26];
        int len = p.length();
        List<Integer> ll = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            maps[s.charAt(i) - 'a']++;
            mapp[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(maps,mapp)) ll.add(0);
        for (int i = len; i < s.length(); i++) {
            maps[s.charAt(i - len) - 'a']--;
            maps[s.charAt(i) - 'a']++;
            if(Arrays.equals(maps,mapp)){
                ll.add(i - len + 1);
            }
        }

        return ll;
    }
}
