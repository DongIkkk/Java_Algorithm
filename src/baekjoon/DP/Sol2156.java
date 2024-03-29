package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];

        dp[1] = arr[1];
        if(n == 1) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n ; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + arr[i]), dp[i-3] + arr[i-1] + arr[i]);
        }

        System.out.println(dp[n]);
    }
}
