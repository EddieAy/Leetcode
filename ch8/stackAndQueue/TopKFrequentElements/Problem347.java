package ch8.stackAndQueue.TopKFrequentElements;

import java.util.*;

public class Problem347 {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        int[] b = new Problem347().topKFrequent(a,2);
    }

    public int[] topKFrequent(int[] nums, int k) {
//        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));

        // 3. 提取排序后的键
//        List<Integer> sortedKeys = new ArrayList<>();
        int[] ans = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entryList) {
            if (index == k) break;
            ans[index] = entry.getKey();
            index++;
        }

        // 打印或使用排序后的键

        return ans;
    }

    public int[] topKFrequent2(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0) +1 );
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[] {num,count});
                }
            }else {
                queue.offer(new int[] {num,count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;

    }

}
