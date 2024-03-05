package ch12DP;

public class Problem474OnesandZeroes {
    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int oneNum,zeroNum;
        for (String str:strs){
            oneNum = 0;
            zeroNum = 0;
            for (char c:str.toCharArray()){
                if(c == '1'){
                    oneNum++;
                }else {
                    zeroNum++;
                }
            }
            for (int i = m; i >= zeroNum ; i--) {
                for (int j = n; j >= oneNum ; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public int findMaxForm(String[] strs, int m, int n){
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        int oneNum,zeroNum;
        for (int k = 1; k<=len;k++){
            oneNum = 0;
            zeroNum = 0;
            for (char c:strs[k - 1].toCharArray()){
                if(c == '0'){
                    zeroNum++; // 正确地统计0的数量
                }else {
                    oneNum++; // 正确地统计1的数量
                }
            }
            for (int i = 0; i <= m ; i++) {
                for (int j = 0;j <= n;j++){
                    dp[k][i][j] = dp[k - 1][i][j];
                    /*
                    * dp[k][i][j] = Math.max(dp[k - 1][i][j],dp[k - 1][i - oneNum][j - zeroNum])
                    * */
                    if(i >= zeroNum && j >= oneNum){
                        dp[k][i][j] = Math.max(dp[k - 1][i][j],dp[k - 1][i - zeroNum][j - oneNum] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
