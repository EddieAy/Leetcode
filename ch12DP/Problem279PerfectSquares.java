package ch12DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem279PerfectSquares {
    public int numSquares(int n) {
        //dp的含义为   和为 n 的完全平方数的最少数量 。
        /*
        * 动态规划状态dp[i][j]可以定义为使用前i个完全平方数时，组成整数j的最少数量。
        * */
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2; // 下一个平方数是当前平方的数加上的差
        }

        int len = squares.size();
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],n);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        /*
        *
        * 其中dp[i][j]表示用前i个完全平方数构成整数j需要的最小完全平方数数
        * */
        for (int i = 1; i <= len ; i++) {//从1 开始 是因为
            for (int j = 1; j <= n ; j++) {
                if(j < squares.get(i - 1)){
                    dp[i][j] = dp[i - 1][j];// 如果当前数j小于完全平方数i的平方，则不能选第i个数
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - squares.get(i - 1)] + 1);
                }
            }
        }
        return dp[len][n];
    }
}
