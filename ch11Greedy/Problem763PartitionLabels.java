package ch11Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem763PartitionLabels {

    /*
    * 记录起始 最后的位置？
    *
    * */

    public static void main(String[] args) {
        new Problem763PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
    }
    public List<Integer> partitionLabels(String s) {
        int[] boundary = new int[26];
        for (int i = 0; i < s.length(); i++) {
            boundary[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int last = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last,boundary[s.charAt(i) - 'a']);
            if(i == last){
                res.add(last - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
