package ch12DP;

import java.util.Scanner;

public class Kama52CompletePack {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int bagWeight = sc.nextInt();
        int[] weights = new int[len];
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }
        int[][] dp = new int[len + 1][bagWeight + 1];
        //dp[0][0] = 0
        for (int i = 1; i <= len ; i++) {
            for (int j = 0; j <= bagWeight ; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= weights[i - 1]){
                    dp[i][j] = Math.max(dp[i][j],dp[i][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        System.out.println(dp[len][bagWeight]);*/
        int len = 4;
        int bagWeight = 5;
        int[] weights = new int[]{1, 2, 3, 4};
        int[] values = new int[]{10,21,30,43};
        completePackOne(len,bagWeight,weights,values);
//        System.out.println();
//        sc.close();
    }

    public static int completePackOne(int len,int bagWeight,int[] weights,int[] values){
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = weights[i]; j <= bagWeight ; j++) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        for (int num:dp){
            System.out.printf(num+" ");
        }

        System.out.println();

        int[] dp1 = new int[bagWeight + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = bagWeight; j >= weights[i] ; j--) {
                dp1[j] = Math.max(dp1[j], dp1[j - weights[i]] + values[i]);
            }
        }
        for (int num:dp1){
            System.out.printf(num+" ");
        }

        return dp[bagWeight];
    }
}
