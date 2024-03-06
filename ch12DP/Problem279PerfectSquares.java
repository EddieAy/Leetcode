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
/*
* 为什么j的循环从i*i开始而不是从0开始，有以下几个原因：

初始条件: dp[0]已经被初始化为0，意味着0可以由0个完全平方数组成，这是一个基础情况。
* 从i*i开始是因为任何小于i*i的数字都不能由当前考虑的完全平方数i*i构成。
* 例如，如果i=2，那么i*i=4，任何小于4的数字都不可能由4作为一个组成部分（因为我们只能使用整数次的平方数，且必须是完全平方数）。*/
    public int numSquares2(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n  ; i++) {
            for (int j = i * i; j <= n ; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
