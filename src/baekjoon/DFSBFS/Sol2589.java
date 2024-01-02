package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2589 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String in = sc.next();
            map[i] = in.toCharArray();
        }

        boolean[][] visited;
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'L') {

                    visited = new boolean[n][m];

                    q.add(new int[] {i,j,0});
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] temp = q.poll();
                        int xx = temp[0];
                        int yy = temp[1];

                        for (int k = 0; k < 4; k++) {
                            int nextx = xx + dx[k];
                            int nexty = yy + dy[k];

                            if(nextx>=0 && nextx<n && nexty >=0 && nexty<m && !visited[nextx][nexty] && map[nextx][nexty] == 'L') {
                                visited[nextx][nexty] = true;
                                if(result < temp[2]+1) result = temp[2]+1;
                                q.add(new int[] {nextx, nexty, temp[2]+1});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
