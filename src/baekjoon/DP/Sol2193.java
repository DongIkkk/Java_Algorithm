package DP;

import java.util.Scanner;

public class Sol2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] dp = new long[N+1];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
