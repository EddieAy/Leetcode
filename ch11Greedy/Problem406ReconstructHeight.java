package ch11Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Problem406ReconstructHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int[] temp:people){
            linkedList.add(temp[1],temp);
        }
        return linkedList.toArray(new int[people.length][]);

    }
}
