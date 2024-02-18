package ch10BackTracking.NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c:chessboard){
            Arrays.fill(c,'.');
        }
        backtrack(n,0,chessboard);
        return res;
    }

    private void backtrack(int n, int row, char[][] chessboard) {
        if(row == n){
            res.add(Array2List(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if(isValid(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';
                backtrack(n,row + 1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    private List<String> Array2List(char[][] chessboard) {
        List<String> res1 = new ArrayList<>();
        for (char[] c:chessboard){
            res1.add(String.copyValueOf(c));
        }
        return res1;
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < row; i++) {
            if(chessboard[i][col] == 'Q'){
                return false;
            }
        }

        for (int i = row - 1,j = col - 1;i >=0&&j >=0;i--,j--){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        for (int i = row - 1,j = col + 1;i >=0&&j < n;i--,j++){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
