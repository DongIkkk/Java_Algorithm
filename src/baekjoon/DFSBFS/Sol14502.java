package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol14502 {
    static int r, c, result;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        Queue<int[]> virus = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[] {i, j});
                }
            }
        }
        result =0;
        gogo(0, virus);
        System.out.println(result);

    }

    static public void gogo(int count, Queue<int[]> q){
        if(count==3){
            int[][] newMap = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            Queue<int[]> newq = new LinkedList<>();
            for (int[] narr: q){
                newq.add(narr);
            }
            int temp = bfs(newMap, newq);
            if(result < temp) result = temp;
            return;
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==0){
                    map[i][j]=3;
                    gogo(count+1, q);
                    map[i][j]=0;
                }
            }
        }
    }

    static public int bfs(int[][] thisMap, Queue<int[]> q){

        visited = new boolean[r][c];

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            visited[nowx][nowy] = true;

            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];

                if(nextx<0 || nexty < 0 || nextx >= r || nexty >= c) continue;

                if(thisMap[nextx][nexty]==0 && !visited[nextx][nexty]){
                    thisMap[nextx][nexty] = 2;
                    q.add(new int[] {nextx, nexty});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(thisMap[i][j] == 0)count++;
            }
        }
        return count;
    }

}
