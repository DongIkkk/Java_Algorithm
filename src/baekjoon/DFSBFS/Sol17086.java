package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol17086 {
    static int N, M, result;
    static int[][] map, dis;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dis = new int[N][M];
        result = 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dis[i][j] = Integer.MAX_VALUE;
                if(map[i][j] == 1) {
                    q.add(new int[] {i, j});
                    dis[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if(dis[nextX][nextY] > dis[now[0]][now[1]] + 1) {
                    dis[nextX][nextY] = dis[now[0]][now[1]] + 1;
                    q.add(new int[] {nextX, nextY});
                    result = Math.max(result, dis[nextX][nextY]);
                }
            }
        }

        System.out.println(result);
    }
}
