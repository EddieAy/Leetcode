package ch12DP;

import java.util.Arrays;

public class Problem63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        /*
        * 1.dp[i][j] 同理表示 达到I J 的步数
        * 2.推理状态方程 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        * 3.初始化
        *
        * */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if(obstacleGrid[0][j] != 1){
                dp[0][j] = 1;
            }else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
/*                if(dp[i][j - 1] == -1 ){
                    dp[i][j] = dp[i - 1][j];
                }else if(dp[i - 1][j] == -1){
                    dp[i][j] = dp[i][j - 1];
                }*/
                if(obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }else {
                    dp[i][j] = 0; //这个为0  我没想到
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
