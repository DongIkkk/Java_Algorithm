package greedy;

import java.io.*;
import java.util.*;

public class Sol1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] now = new int[N][M];
        int[][] target = new int[N][M];

        for (int i = 0; i < N; i++) {
            now[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < N; i++) {
            target[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if(now[i][j] != target[i][j]) {
                    count++;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            now[i+k][j+l] = now[i+k][j+l] == 0 ? 1 : 0;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(now[i][j] != target[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(count);
    }
}
