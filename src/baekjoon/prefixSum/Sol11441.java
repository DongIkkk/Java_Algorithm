package prefixSum;

import java.io.*;
import java.util.*;

public class Sol11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inputArr = new int[N+1];
        int[] pSum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
            pSum[i] += pSum[i-1] + inputArr[i];
        }
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(pSum[b] - pSum[a-1]).append("\n");
        }
        System.out.println(sb);
    }
}
