package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2468 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        int max = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(max < map[i][j]) max = map[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < max; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visited[j][k] && map[j][k] > i){
                        count++;
                        dfs(i,j,k);
                    }
                }
            }
            if (result<count) result = count;
        }

        System.out.println(result);

    }

    public static void dfs(int rain, int x, int y){
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx>=0 && nexty>=0 && nextx<n && nexty<n){
                if(!visited[nextx][nexty] && map[nextx][nexty]>rain){
                    dfs(rain, nextx, nexty);
                }
            }
        }

    }
}
