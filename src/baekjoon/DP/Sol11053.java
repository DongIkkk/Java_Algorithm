package DP;

import java.io.*;
import java.util.*;

public class Sol11053 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
