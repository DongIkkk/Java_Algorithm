package implementation;

import java.io.*;
import java.util.*;

public class Sol14500 {
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new boolean[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y, int size, int sum) {
        if(size == 4) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx>=0 && nexty>=0 &&nextx<N && nexty<M && !visited[nextx][nexty]) {
                if(size == 2) {
                    visited[nextx][nexty] = true;
                    dfs(x, y, size+1, sum + map[nextx][nexty]);
                    visited[nextx][nexty] = false;
                }

                visited[nextx][nexty] = true;
                dfs(nextx, nexty, size+1, sum + map[nextx][nexty]);
                visited[nextx][nexty] = false;
            }
        }

    }
}
