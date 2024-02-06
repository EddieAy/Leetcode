package ch10BackTracking.Combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem17 {

    public static void main(String[] args) {
        String s = "a"+('a'+1)+("a"+2);
        System.out.println(s);

    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Map<Character, String> numberToLetters = createMap();

    private Map<Character, String> createMap() {
        Map<Character, String> numberToLetters = new HashMap<>();
        numberToLetters.put('2', "abc");
        numberToLetters.put('3', "def");
        numberToLetters.put('4', "ghi");
        numberToLetters.put('5', "jkl");
        numberToLetters.put('6', "mno");
        numberToLetters.put('7', "pqrs");
        numberToLetters.put('8', "tuv");
        numberToLetters.put('9', "wxyz");
        return numberToLetters;
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return res;
        }
        backtrack(digits,0);
        return res;
    }

    private void backtrack(String digits, int index) {
        if(index == digits.length()){
            res.add(new String(sb));
            return;
        }

        String letters = numberToLetters.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            int len = sb.length();
            sb.append(letters.charAt(i));
            backtrack(digits,index + 1);
            sb.setLength(len);
        }
    }
}
