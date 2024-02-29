package ch12DP;

public class Problem62UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m, int n) {
        /*
        * 1.dp[i][j]的含义 到达i j 所需要的步数
        * 2.确定递推公式  dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        * 3.初始化dp[0][0] = 1
        * dp[1][0] = dp[0][0]
        *
        * */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m;i++){
            dp[i][0] = 1;
        }
        for (int j = 0; j < n;j++){
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
