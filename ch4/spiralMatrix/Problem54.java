package ch4.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public static void main(String[] args) {
        int[][] a = {{2,3,4},{5,6,7},{8,9,10},{11,12,13}};
//        int[][] a = {{3},{2}};

        if(a[0].length == 0){

            return new int[];
        }
        List<Integer> lst = spiralOrder(a);
        int[] a1 = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            a1[i] = lst.get(i);
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();
        int length = matrix[0].length;
        int width = matrix.length;
        System.out.println(length);
        System.out.println(width);
        modifyArray(matrix,0,0,length,width,lst);

        return lst;
    }

    private static void modifyArray(int[][] a, int row, int col,int length,int width,List<Integer> lst) {
        if (Math.min(length,width) == 1){
            if (width <= length){
                for (int i = col; i < col + length; i++) {
                    lst.add(a[row][i]);
                }
            }else {//长度为1  宽很大0 0   1 0  2 0
                for (int i = row; i < row + width; i++) {
                    lst.add(a[i][col]);
                }
            }
            return;


        }else if (Math.min(length,width) == 0){
            return;
        }else {
            for (int i = col; i < col + length; i++) {       //从第一行 左到右
                if (i != col + length - 1){
                    lst.add(a[row][i]);
                }
            }
            for (int i = row; i < row + width; i++) {       //从最后一列 上到下
                if(i != row + width - 1){
                    lst.add(a[i][col + length - 1]);
                }
            }
            for (int i = col + length - 1 ; i >= col; i--) {     //从最后一行 右到左
                if (i != col){
                    lst.add(a[row + width - 1][i]);
                }
            }
            for (int i = row + width - 1 ; i >= row + 1; i--) {     //从第一列 下到上
                lst.add(a[i][col]);
            }
            modifyArray(a,row+1,col+1,length -2,width - 2,lst);
        }
    }
}
