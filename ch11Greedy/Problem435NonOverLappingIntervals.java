package ch11Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        return 0;
    }
}
