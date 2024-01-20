package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol7562 {
    static int l;
    static int[][] map;
    static int[][] dis;

    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        testcase:
        for (int i = 0; i < tc; i++) {
            l = sc.nextInt();
            map = new int[l][l];
            dis = new int[l][l];

            // 현재칸
            int cx = sc.nextInt();
            int cy = sc.nextInt();

            // 목표칸
            int tx = sc.nextInt();
            int ty = sc.nextInt();

            if(cx == tx && cy == ty) {
                System.out.println(0);
                continue testcase;
            }

            Queue<int[]> q = new LinkedList<>();

            q.add(new int[] {cx, cy, 1});
            dis[cx][cy] = 1;

            while(q.size() != 0) {
                int[] now = q.poll();
                int nowx = now[0];
                int nowy = now[1];
                int nowDis = now[2];

                for (int j = 0; j < 8; j++) {
                    int nextx = nowx + dx[j];
                    int nexty = nowy + dy[j];
                    if(nextx >= 0 && nextx < l && nexty >= 0 && nexty < l) {
                        if(dis[nextx][nexty] > 0) {
                            continue;
                        }

                        if( nextx == tx && nexty == ty) {
                            System.out.println(nowDis);
                            continue testcase;
                        } else {
                            q.add(new int[] {nextx, nexty, nowDis+1});
                            dis[nextx][nexty] = nowDis+1;
                        }
                    }
                }
            }

        }
    }
}
