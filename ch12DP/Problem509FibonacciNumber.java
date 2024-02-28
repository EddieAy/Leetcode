package ch12DP;

public class Problem509FibonacciNumber {

    public static void main(String[] args) {
        int ans = new Problem509FibonacciNumber().fib(3);

    }
    public int fib(int n) {
        if(n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;      //0 1 1 2
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
