package ch0Review.ch3Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str:strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String t1 = new String(temp);
            if(!map.containsKey(t1)){
                List<String> ans = new ArrayList<>();
                ans.add(str);
                map.put(t1,ans);
            }else {
                map.get(t1).add(str);
            }

        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
