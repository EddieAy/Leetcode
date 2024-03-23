package ch0Review.ch3Hash;

public class P383RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] s1 = new int[26];
        int[] m1 = new int[26];
        for (char s:ransomNote.toCharArray()){
            s1[s - 'a']++;
        }
        for (char m:magazine.toCharArray()){
            m1[m - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(s1[i] > m1[i]){
                return false;
            }
        }
        return true;
    }
}
