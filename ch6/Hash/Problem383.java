package ch6.Hash;

public class Problem383 {
    public static void main(String[] args) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] chm = magazine.toCharArray();
        char[] chr = ransomNote.toCharArray();
        int[] count = new int[26];
        for (char c:chm){
            count[c - 'a']++;
        }

        for (char c:chr){
            if (count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;
    }
}
