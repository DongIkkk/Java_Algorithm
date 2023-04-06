package SWTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1949 {
    static int N, K, result;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            result = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > max) max = map[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == max){
                        visited = new boolean[N][N][2];
                        visited[i][j][1] = true;
                        visited[i][j][0] = true;
                        dfs(i, j, 1, 1);
                        visited[i][j][1] = false;
                        visited[i][j][0] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);
        }
    }

    static public void dfs(int x, int y, int hklength, int cancon){
        if(result <= hklength) {
            result = hklength;
        }

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];
            if(nextx<0 || nexty<0 || nextx>=N || nexty>=N) continue;

            if(!visited[nextx][nexty][1] && !visited[nextx][nexty][0] && map[nextx][nexty] < map[x][y]) {
                visited[nextx][nexty][cancon] = true;
                dfs(nextx, nexty, hklength + 1, cancon);
                visited[nextx][nexty][cancon] = false;
            } else if(cancon == 1 && !visited[nextx][nexty][0] && !visited[nextx][nexty][1]){
                for (int j = 1; j <= K ; j++) {
                    map[nextx][nexty] -= j;
                    if(map[nextx][nexty] < map[x][y]){
                        visited[nextx][nexty][0] = true;
                        dfs(nextx, nexty, hklength+1, 0);
                        visited[nextx][nexty][0] = false;
                    }
                    map[nextx][nexty] += j;
                }
            }

        }

    }
}
