package prefixSum;

import java.io.*;
import java.util.*;

public class Sol16507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] inputArr = new int[R+1][C+1];
        int[][] pSum = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
                pSum[i][j] = pSum[i][j-1] + inputArr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int sum = 0;
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = temp[0]; j <= temp[2]; j++) {
                sum += (pSum[j][temp[3]] - pSum[j][temp[1]-1]);
            }
            sb.append(sum / ((temp[2] - temp[0] + 1) * (temp[3] - temp[1] + 1))).append("\n");
        }
        System.out.println(sb);
    }
}
