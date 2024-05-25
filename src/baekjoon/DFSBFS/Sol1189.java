package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol1189 {
    static int R, C, K, result;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String S = br.readLine();
            for (int j = 0; j < C; j++) {
                if(S.charAt(j) == 'T') map[i][j] = 1;
            }
        }

        result = 0;
        visited = new boolean[R][C];
        visited[R-1][0] = true;
        dfs(1, R-1, 0);

        System.out.print(result);
    }

    public static void dfs(int count, int x, int y) {
        if(count == K && x == 0 && y == C-1) {
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) continue;

            if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                visited[nextX][nextY] = true;
                dfs(count+1, nextX, nextY);
                visited[nextX][nextY] = false;
            }
        }
    }
}
