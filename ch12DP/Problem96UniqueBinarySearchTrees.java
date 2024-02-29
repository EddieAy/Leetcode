package ch12DP;

public class Problem96UniqueBinarySearchTrees {
    public int numTrees(int n) {
        /*
        *
        * 在上面的分析中，其实已经看出其递推关系，
        * dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
        j相当于是头结点的元素，从1遍历到i为止。
        所以递推公式：dp[i] += dp[j - 1] * dp[i - j]; ，j-1 为j为头结点左子树节点数量，i-j 为以j为头结点右子树节点数量
        * */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
