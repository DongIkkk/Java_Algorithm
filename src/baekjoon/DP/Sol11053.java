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

        dp[0] = 1;
        int result = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j], dp[i]);
                }
            }
            dp[i]++;
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}
