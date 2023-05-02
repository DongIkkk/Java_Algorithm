package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1600 {
    static int[] dx = {-1, 0, 1, 0, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {0, 1, 0, -1, -2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        boolean[][][] visited = new boolean[x][y][K+1];
        int[][] map = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, K, 0});

        int result = Integer.MAX_VALUE;


        while(q.size()!=0){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            int horseCnt = now[2];
            int count = now[3];

            if(count < result) result = count;

            for (int i = 0; i < 12; i++) {

                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];
                if(nextx<0 || nexty<0 || nextx >= x || nexty >= y) continue;

                if(nextx == x-1 && nexty == y-1){
                    if(count < result) result = count;
                    continue;
                }

                if(map[nextx][nexty]==0 && !visited[nextx][nexty][horseCnt]){

                    visited[nextx][nexty][horseCnt] = true;
                    q.add(new int[] { nextx, nexty, horseCnt-1, count+1});
                }

            }

        }
        System.out.println(result);

    }
}
