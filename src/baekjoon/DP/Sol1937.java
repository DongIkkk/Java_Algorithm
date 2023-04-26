package DP;

import java.io.*;
import java.util.*;

public class Sol1937 {
    static int N;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int max = -1;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                dp[i][j] = DFS(i, j);
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);
//        for(int i = 0; i<N; i++) {
//            System.out.println();
//            for(int j = 0; j<N; j++) {
//                System.out.printf("%d ", dp[i][j]);
//            }
//        }
    }

    public static int DFS(int x, int y) {

        if(dp[x][y] != -1) return dp[x][y];

        int temp = 0;
        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx < 0 || nexty < 0 || nextx>=N || nexty>=N) continue;

            if(map[nextx][nexty] > map[x][y]){
                int aa = DFS(nextx, nexty);
                temp = Math.max(temp, aa);
            }
        }
        dp[x][y] = 1+temp;
        return dp[x][y];
    }
}
