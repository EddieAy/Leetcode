package ch11Greedy;

import java.util.Arrays;

public class Problem135Candy {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i - 1] < ratings[i]){
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0 ; i--) {
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(right[i],left[i]);
        }
        return count;
    }

}
