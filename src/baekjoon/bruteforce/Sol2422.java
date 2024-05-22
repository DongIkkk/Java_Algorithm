package bruteforce;

import java.io.*;
import java.util.*;

public class Sol2422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] check = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = check[b][a] = true;
        }

        int count = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = i+1; j < N+1; j++) {
                if(check[i][j]) continue;
                for (int k = j+1; k < N+1; k++) {
                    if(check[i][k] || check[j][k]) continue;
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
