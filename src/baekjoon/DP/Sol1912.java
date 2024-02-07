package DP;

import java.util.*;
import java.io.*;

public class Sol1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = numArr[0];

        int result = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(numArr[i] + dp[i-1], numArr[i]);
            result = Math.max(dp[i], result);
        }

        System.out.println(result);



    }
}
