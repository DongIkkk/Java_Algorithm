package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> q2 = new LinkedList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        int result = 0;
        while(canMove()){
            Movement();
            result++;
        }

        System.out.println(result);
    }

    private static void Movement() {
        int[][] newMap = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if(!visited[i][j]){
                    q.clear();
                    q2.clear();

                    q.add(new int[] {i, j});
                    q2.add(new int[] {i, j});
                    visited[i][j] = true;
                    int total = 0;

                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        total += map[now[0]][now[1]];
                        for (int k = 0; k < 4; k++) {
                            int nextx = now[0] + dx[k];
                            int nexty = now[1] + dy[k];
                            if(nextx < 0 || nexty < 0 || nextx >= N || nexty >= N || visited[nextx][nexty]) continue;

                            int dif = Math.abs(map[now[0]][now[1]] - map[nextx][nexty]);
                            if(L <= dif && dif <= R) {
                                q.add(new int[] {nextx, nexty});
                                q2.add(new int[] {nextx, nexty});
                                visited[nextx][nexty] = true;
                            }
                        }
                    }

                    int count = q2.size();
                    int avg = total / count;
                    while(!q2.isEmpty()) {
                        int[] now = q2.poll();
                        newMap[now[0]][now[1]] = avg;
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    private static boolean canMove() {
        int temp;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    if(i+dx[k] < N && j+dy[k] < N){
                        temp = Math.abs(map[i][j] - map[i+dx[k]][j+dy[k]]);
                        if(L <= temp && temp <= R) return true;
                    }
                }
            }
        }
        return false;
    }

}
