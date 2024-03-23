package ch0Review.ch3Hash;

public class P242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for (char s1:s.toCharArray()){
            res[s1 - 'a']++;
        }
        for (char t1:t.toCharArray()){
            res[t1 - 'a']--;
        }
        for (int i = 0; i < res.length; i++) {
            if(res[i] != 0){
                return  false;
            }
        }
        return true;
    }
}
