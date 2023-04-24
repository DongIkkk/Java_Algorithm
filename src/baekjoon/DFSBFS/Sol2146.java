package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2146 {
    static int count = 0;
    static int N, min;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>0 && !visited[i][j]){
                    count++;
                    numbering(i, j);
                }
            }
        }
        count=1;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == count){
                    bfs();
                    count++;
                }
            }
        }

        System.out.println(min);


    }

    public static void bfs(){
        visited = new boolean[N][N];
        int[][] dist = new int[N][N];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j]==count){
                    q.add(new int[] {i, j});
                    visited[i][j]=true;
                }
            }
        }

        while(q.size()!=0){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];

                if(nextx<0 || nexty<0 || nextx>=N || nexty>=N) continue;

                if(map[nextx][nexty]>0 && map[nextx][nexty]!=count){
                    if(min > dist[nowx][nowy]){
                        min = dist[nowx][nowy];
                    }
                    return;
                }

                if(map[nextx][nexty]==0 && !visited[nextx][nexty]){
                    dist[nextx][nexty] = dist[nowx][nowy] + 1;

                    visited[nextx][nexty] = true;
                    q.add(new int[] {nextx, nexty});
                }
            }

        }

    }

    public static void numbering(int x, int y){
        Queue<int[]> numq = new LinkedList<>();
        numq.add(new int[] {x, y});
        visited[x][y] = true;
        map[x][y] = count;

        while(numq.size()!=0){
            int[] now = numq.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];

                if(nextx<0 || nexty<0 || nextx>=N || nexty>=N) continue;

                if(map[nextx][nexty]>0 && !visited[nextx][nexty]){
                    map[nextx][nexty] = count;
                    visited[nextx][nexty] = true;
                    numq.add(new int[] {nextx, nexty});
                }
            }

        }
    }
}
