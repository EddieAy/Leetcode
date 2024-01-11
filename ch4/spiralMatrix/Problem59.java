package ch4.spiralMatrix;
public class Problem59 {

    public static void main(String[] args) {
        int[][] a = generateMatrix(4);
    }
    public static int[][] generateMatrix(int n) {

        int[][] a = new int[n][n];
        int number = 1;
        modifyArray(a,0,0,n,number);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        return a;
    }

    private static void modifyArray(int[][] a, int row, int col, int n,int number) {
        if (n == 1){
            a[row][col] = number;
            return;
        }else if (n == 0){
            return;
        }else {
            for (int i = col; i < col + n; i++) {       //从第一行 左到右
                a[row][i] = number;
                number++;
            }
            number--;
            for (int i = row; i < row + n; i++) {       //从最后一列 上到下
                a[i][col + n - 1] = number;
                number++;
            }
            number--;
            for (int i = col + n - 1 ; i >= col; i--) {     //从最后一行 右到左
                a[row + n - 1][i] = number;
                number++;
            }
            number--;
            for (int i = row + n - 1 ; i >= row + 1; i--) {     //从第一列 下到上
                a[i][col] = number;
                number++;
            }
            modifyArray(a,row+1,col+1,n - 2,number);
        }
    }
}