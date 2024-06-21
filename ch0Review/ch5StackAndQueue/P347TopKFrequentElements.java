package ch0Review.ch5StackAndQueue;

import java.util.*;

public class P347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key:map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else if (map.get(key) > map.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
