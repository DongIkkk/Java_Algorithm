package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol14940 {
    static int n, m;
    static int x, y;
    static int[][] map, result;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
                if(map[i][j] == 2) {
                    result[i][j] = 0;
                    q.add(new int[] {i,j});
                    visited[i][j] = true;
                }
                if(map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = temp[0] + dx[i];
                int nexty = temp[1] + dy[i];

                if(nextx<0 || nexty<0 || nextx>=n || nexty>=m) continue;

                if(!visited[nextx][nexty] && map[nextx][nexty] == 1) {
                    result[nextx][nexty] = result[temp[0]][temp[1]] + 1;
                    visited[nextx][nexty] = true;
                    q.add(new int[] {nextx, nexty});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
