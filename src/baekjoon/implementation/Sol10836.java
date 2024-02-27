package implementation;

import java.io.*;
import java.util.*;

public class Sol10836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] map = new int[2*M-1];
        Arrays.fill(map, 1);
        int[] countSum = new int[2*M];

        int[] day = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            day[0] = Integer.parseInt(st.nextToken());
            day[1] = Integer.parseInt(st.nextToken());
            day[2] = Integer.parseInt(st.nextToken());

            countSum[2*M -1 - day[2]] += 1;
            countSum[2*M -1 - day[2] - day[1]] += 1;
        }

        int temp = 0;
        for (int i = 0; i < 2*M-1; i++) {
            temp += countSum[i];
            map[i] += temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = M-1; i >= 0; i--) {
            result.append(map[i]);
            result.append(" ");

            for (int j = M; j < 2*M-1; j++) {
                result.append(map[j]);
                result.append(" ");
            }

            result.append("\n");
        }

        System.out.print(result.toString());

    }
}
