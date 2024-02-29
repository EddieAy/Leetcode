package ch12DP;

public class Problem343IntegerBreak {
    public int integerBreak(int n) {
        /*
        1.dp[] 是最大乘积
        *2.状态如何转移
        没思路...


        对于一个 >=2的正整数i
        它的拆分可以有两种
        1：   j   i - j  只拆两个
        2：   j   dp[i - j] 其中 dp[i]  表示将正整数 i 拆分成至少两个正整数的和之后，这些正整数的最大乘积。
        * */

        int[] dp = new int[n + 1];
        for (int i = 2; i <=n ; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax,Math.max(j * (i - j),j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
