package DP;

import java.util.Scanner;

public class Sol2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[5001];

        dp[1] = -1;
        dp[2] = -1;
        dp[3] = 1;
        dp[4] = -1;
        dp[5] = 1;
        dp[6] = 2;

        for (int i = 7; i <= N; i++) {
            if(dp[i-3]==-1 && dp[i-5]==-1){
                dp[i] = -1;
            } else if(dp[i-3] <= dp[i-5] && dp[i-3]!=-1 && dp[i-5]!=-1){
                dp[i] = dp[i-3]+1;
            } else if(dp[i-5]<=dp[i-3] && dp[i-3]!=-1 && dp[i-5]!=-1){
                dp[i] = dp[i-5]+1;
            } else if(dp[i-3]!=-1){
                dp[i] = dp[i-3]+1;
            } else if(dp[i-5]!=-1){
                dp[i] = dp[i-5]+1;
            } else{
                dp[i] = -1;
            }
        }
        System.out.println(dp[N]);

    }
}
