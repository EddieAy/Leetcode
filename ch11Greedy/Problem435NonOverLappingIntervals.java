package ch11Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem435NonOverLappingIntervals {
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int sum = 0;
        int end = intervals[0][1];
        for (int i = 1;i < intervals.length; i++) {
            if(intervals[i][0] >= end){
                // [1,2] [2,3] 这里是没有重叠    ！！


                /* 在打气球 是重叠的
                * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
                输出：2
                解释：气球可以用2支箭来爆破:
                - 在x = 2处发射箭，击破气球[1,2]和[2,3]*/
                end = intervals[i][1];
            }else {
                end = Math.min(end,intervals[i][1]);
                sum++;
            }
        }
        return sum;
    }

    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        /*
        * 此时问题就是要求非交叉区间的最大个数
        *
        * */
        int count = 1;//这个求的是非交叉的个数
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            /*[1,2] [2,3] 就是不交叉的
            * */
            if(end <= intervals[i][0]){
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;//总数 - 非交叉个数 = 需要移除的  交叉个数？
    }
}
