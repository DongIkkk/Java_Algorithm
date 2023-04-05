package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2206 {
    static int n, m;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] carr = s.toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = carr[j] - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0,1});
        visited[0][0][1] = 1;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            int canbreak = now[2];

            if(nowx == n-1 && nowy == m-1){
                System.out.println(visited[nowx][nowy][now[2]]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];

                if(nextx<0 || nexty<0 || nextx>=n || nexty>=m) continue;

                if(map[nextx][nexty] == 1 && canbreak == 1) {
                    visited[nextx][nexty][0] = visited[nowx][nowy][canbreak] + 1;
                    q.add(new int[] {nextx, nexty, 0});
                } else if( map[nextx][nexty] == 0 && visited[nextx][nexty][canbreak]==0) {
                    visited[nextx][nexty][canbreak] = visited[nowx][nowy][canbreak] + 1;
                    q.add(new int[] {nextx, nexty, canbreak});
                }

            }
        }
        System.out.println(-1);
    }
}
