package DP;

import java.util.Scanner;

public class Sol11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            if(i>=2) {
                dp[i] = ((dp[i-1]%10007) + (dp[i-2]%10007))%10007;
            }
        }
        System.out.println(dp[n]);
    }
}
