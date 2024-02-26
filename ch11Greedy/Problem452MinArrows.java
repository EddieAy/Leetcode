package ch11Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Problem452MinArrows {

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        int a = new Problem452MinArrows().findMinArrowShots(points);
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
                return Integer.compare(o1[0], o2[0]);
            }
        });
//        System.out.println(Arrays.deepToString(points));
        int sum = 1;
        for (int i = 1; i < points.length ; i++) {
            if(points[i][0] > points[i - 1][1]){
                sum++;
            }else {
                points[i][1] = Math.min(points[i][1],points[i - 1][1]);
            }
        }
        return sum;
    }
}
