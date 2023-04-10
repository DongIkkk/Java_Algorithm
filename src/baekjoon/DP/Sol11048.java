package DP;

import java.util.Scanner;

public class Sol11048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        int[] dx = {1, 0, 1};
        int[] dy = {0, 1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = map[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(nx>=n || ny>=m) continue;
                    if(dp[i][j]+map[nx][ny] > dp[nx][ny]) dp[nx][ny] = dp[i][j]+map[nx][ny];
                }

            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
