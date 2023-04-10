package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][3];
        int[][] dpmin = new int[2][3];
        int[][] dpmax = new int[2][3];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dpmin[0][0] = map[0][0];
        dpmin[0][1] = map[0][1];
        dpmin[0][2] = map[0][2];

        dpmax[0][0] = map[0][0];
        dpmax[0][1] = map[0][1];
        dpmax[0][2] = map[0][2];

        for (int i = 1; i < n; i++) {
            dpmin[1][0] = map[i][0] + Math.min(dpmin[0][0], dpmin[0][1]);
            dpmin[1][1] = map[i][1] + Math.min(Math.min(dpmin[0][0], dpmin[0][1]), dpmin[0][2]);
            dpmin[1][2] = map[i][2] + Math.min(dpmin[0][1], dpmin[0][2]);

            dpmin[0][0] = dpmin[1][0];
            dpmin[0][1] = dpmin[1][1];
            dpmin[0][2] = dpmin[1][2];

            dpmax[1][0] = map[i][0] + Math.max(dpmax[0][0], dpmax[0][1]);
            dpmax[1][1] = map[i][1] + Math.max(Math.max(dpmax[0][0], dpmax[0][1]), dpmax[0][2]);
            dpmax[1][2] = map[i][2] + Math.max(dpmax[0][1], dpmax[0][2]);

            dpmax[0][0] = dpmax[1][0];
            dpmax[0][1] = dpmax[1][1];
            dpmax[0][2] = dpmax[1][2];
        }

        System.out.printf("%d %d",Math.max(Math.max(dpmax[0][0], dpmax[0][1]), dpmax[0][2]), Math.min(Math.min(dpmin[0][0], dpmin[0][1]), dpmin[0][2]));
    }
}
