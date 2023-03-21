package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dis;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visited = new boolean[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] carr = s.toCharArray();

            for (int j = 0; j < m; j++) {
                map[i][j] = carr[j] - '0';

            }
        }

        count = 0;
        bfs(0,0);

        System.out.println(dis[n-1][m-1]);

    }

    public static void bfs(int x, int y){
        visited[x][y] = true;
        dis[x][y] = 1;
        q.add(new int[] {x, y});

        while(q.size()!=0){
            int[] temp = q.poll();

            if(temp[0] == n && temp[1] == m){
                count++;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextx = temp[0] + dx[i];
                int nexty = temp[1] + dy[i];

                if(nextx>=0 && nextx<n && nexty>=0 && nexty<m){
                    if(map[nextx][nexty] == 1 && !visited[nextx][nexty]){
                        dis[nextx][nexty] = dis[temp[0]][temp[1]] + 1;
                        q.add(new int[] {nextx, nexty});
                        visited[nextx][nexty] = true;
                    }
                }
            }
        }

    }
}