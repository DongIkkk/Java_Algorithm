package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol2573 {
    static int x, y, iceCnt;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new int[x][y];
        iceCnt = 0;
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0) iceCnt++;
            }
        }
        int count = 0;
        while(true){
            // 몇덩이 인지 체크
            int temp = check();
            if(temp == -1){
                System.out.println(0);
                break;
            }
            if(temp != iceCnt){
                System.out.println(count);
                break;
            }
            oneyear();
            count++;
        }

        

    }

    static public int check(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(map[i][j]>0){

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    boolean[][] visited = new boolean[x][y];
                    visited[i][j] = true;
                    int bfscount=1;

                    while(q.size()!=0){
                        int[] now = q.poll();
                        int nowx = now[0];
                        int nowy = now[1];

                        for (int k = 0; k < 4; k++) {
                            int nextx = nowx + dx[k];
                            int nexty = nowy + dy[k];
                            if(nextx<0 || nexty<0 || nextx>=x || nexty>=y) continue;

                            if(map[nextx][nexty]>0 && !visited[nextx][nexty]){
                                bfscount++;
                                visited[nextx][nexty] = true;
                                q.add(new int[] {nextx, nexty});
                            }
                        }
                    }

                    return bfscount;





                }
            }
        }

        return -1;
    }

    //1년이 지나면
    static public void oneyear(){
        int[][][] map2 = new int[x][y][1];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int count = 0;
                if(map[i][j]>0){
                    for (int k = 0; k < 4; k++) {
                        int nextx = i+dx[k];
                        int nexty = j+dy[k];
                        if(nextx<0 || nexty<0 || nextx>=x || nexty>=y) continue;

                        if(map[nextx][nexty]==0) count++;
                    }
                    map2[i][j][0] = count;
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] > 0) {
                    map[i][j] = map[i][j] - map2[i][j][0];
                    if(map[i][j]<=0) {
                        map[i][j]=0;
                        iceCnt--;
                    }
                }
            }
        }
    }
}
