package ch0Review.ch1Array;

import java.util.ArrayList;
import java.util.List;

public class P54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int l = 0,r = n - 1,t = 0,b = m - 1,x=0;
        while (true){
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            if(t > b) break;
            for (int i = t; i <= b ; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if(r < l) break;
            for (int i = r; i >= l ; i--) {
                res.add(matrix[b][i]);
            }
            b--;
            if(b < t) break;
            for (int i = b; i >= t ; i--) {
                res.add(matrix[i][l]);
            }
            l++;
            if(l > r) break;
        }
        return res;
    }
}
