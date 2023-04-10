package DP;

import java.util.Scanner;

public class Sol2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[301];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }
        int[] dp = new int[301];

        dp[1] = stairs[1];
        for (int i = 2; i <= n; i++) {
            if(i==2){
                dp[2] = stairs[1] + stairs[2];
            }else if(i==3){
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            }else{
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
            }
        }

        System.out.println(dp[n]);
    }
}
