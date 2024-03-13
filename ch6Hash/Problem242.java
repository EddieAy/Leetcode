package ch6Hash;

import java.util.HashMap;

/*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。*/
public class Problem242 {
    public static void main(String[] args) {
//        System.out.println(isAnagram( "rat","car"));
        int a = 'c' - 'a';
        System.out.println(a);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!map.containsKey(ch)){
                return false;
            }
            map.put(ch,map.get(ch) - 1);
            if (map.get(ch) == 0){
                map.remove(ch);
            }
        }

        return map.isEmpty();
    }

    public static boolean isAnagram2(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        if(chs.length != cht.length) return false;
        int[] count = new int[26];

        for (char c:chs){
            count[c - 'a']++;
        }
        for (char c:cht){
            count[c - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0) return false;
        }


        return true;
    }
}
