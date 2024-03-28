package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol21736 {
    static int N, M;
    static int x, y;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'I'){
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        int result = 0;

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = temp[0] + dx[i];
                int nexty = temp[1] + dy[i];

                if(nextx < 0 || nexty < 0 || nextx >= N || nexty >= M || visited[nextx][nexty]) continue;

                if(map[nextx][nexty] != 'X'){
                    if(map[nextx][nexty] == 'P') result++;
                    q.add(new int[] {nextx, nexty});
                    visited[nextx][nexty] = true;
                }
            }
        }

        System.out.println(result == 0 ? "TT" : result);

    }
}
