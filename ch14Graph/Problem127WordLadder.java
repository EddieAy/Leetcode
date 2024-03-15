package ch14Graph;

import java.util.*;

public class Problem127WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(set.isEmpty() || !set.contains(endWord)){
            return 0;
        }
        Deque<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String,Integer> map = new HashMap<>();
        map.put(beginWord,1);

        while (!queue.isEmpty()){
            String word = queue.poll();
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] chs = word.toCharArray();
                for (char k = 'a'; k <= 'z';k++){
                    chs[i] = k;
                    String newWord = String.valueOf(chs);
                    if(newWord.equals(endWord)){
                        return path + 1;
                    }
                    if(set.contains(newWord) && !map.containsKey(newWord)){
                        map.put(newWord,path + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;

    }
}
