package ch10BackTracking.ReconstructItinerary;

import java.util.*;

public class Problem332 {

    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
        });
        path.add("JFK");
        backtrack(tickets,new boolean[tickets.size()]);
        return res;
    }

    private boolean backtrack(List<List<String>> tickets, boolean[] used) {
        if(path.size() == tickets.size() + 1){
            res = new ArrayList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if(!used[i] && tickets.get(i).get(0).equals(path.getLast())){
                path.add(tickets.get(i).get(1));
                used[i] = true;

                if(backtrack(tickets,used)){
                    return true;
                }

                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }

    Deque<String> res1 = new LinkedList<>();
    Map<String,Map<String,Integer>> map = new HashMap<>();
    public List<String> findItinerary2(List<List<String>> tickets) {
        for (List<String> t:tickets){
            Map<String,Integer> temp;
            if(map.containsKey(  t.get(0)   )){  //"JFK"
                temp = map.get(t.get(0));   //Map<String,Integer> temp
                temp.put(t.get(1),temp.getOrDefault(t.get(1),0) + 1);
            }else {
                temp = new HashMap<>();
                temp.put(t.get(1),1);
            }
            map.put(t.get(0),temp);
        }
        res1.add("JFK");
        backtrack2(tickets.size());
        return new ArrayList<>(res1);
    }

    private boolean backtrack2(int tickets) {
        if(res1.size() == tickets + 1){
            return true;
        }

        String last = res1.getLast();//  JFK
        if(map.containsKey(last)){      // target  "SFO": 1,  map.get(last).entrySet() {"SFO": 1, "ATL": 1},
            for (Map.Entry<String,Integer> target:map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res1.add(target.getKey());
                    target.setValue(count - 1);
                    if (backtrack2(tickets)){
                        return true;
                    }
                    res1.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
