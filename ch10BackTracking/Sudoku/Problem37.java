package ch10BackTracking.Sudoku;

public class Problem37 {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k < '9';k++){
                    if(isValidSudoku(i,j,k,board)){
                        board[i][j] = k;
                        if(backtrack(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValidSudoku(int row,int col,char val,char[][] board) {
        for (int i = 0; i < 9; i++) {
            if(board[row][i] == val){
                return false;
            }
        }

        for (int j = 0; j < 9; j++) {
            if(board[j][col] == val){
                return false;
            }
        }

        int startRow = (row / 3 ) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if(board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
}
