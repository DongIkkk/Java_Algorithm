package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol7576 {
    static int x, y, result;
    static int[][] tomato;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        tomato = new int[x][y];

        q = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1){
                    q.add(new int[] {i,j});
                }
            }
        }

        if(tmtCheck()) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = temp[0] + dx[i];
                int nexty = temp[1] + dy[i];

                if(nextx>=0 && nexty>=0 && nextx<x && nexty<y){
                    if(tomato[nextx][nexty]==0 || tomato[nextx][nexty] > tomato[temp[0]][temp[1]] + 1){
                        tomato[nextx][nexty] = tomato[temp[0]][temp[1]] + 1;
                        q.add(new int[] {nextx, nexty});
                    }
                }
            }
        }
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < y; j++) {
//                if(tomato[i][j]==1){
//                    bfs(i,j);
//                }
//            }
//        }

        result = -1;
        if(!tmtCheck()){
            System.out.println(-1);
        } else{
            System.out.println(result-1);
        }

//        for (int[] narr : tomato){
//            System.out.println(Arrays.toString(narr));
//        }

    }

//    static public void bfs(int r, int c){
//
//        while(!q.isEmpty()){
//            int[] temp = q.poll();
//
//            for (int i = 0; i < 4; i++) {
//                int nextx = temp[0] + dx[i];
//                int nexty = temp[1] + dy[i];
//
//                if(nextx>=0 && nexty>=0 && nextx<x && nexty<y){
//                    if(tomato[nextx][nexty]==0 || tomato[nextx][nexty] > tomato[temp[0]][temp[1]] + 1){
//                        tomato[nextx][nexty] = tomato[temp[0]][temp[1]] + 1;
//                        q.add(new int[] {nextx, nexty});
//                    }
//                }
//            }
//        }
//    }

    static public boolean tmtCheck(){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(result < tomato[i][j]) result = tomato[i][j];
                if(tomato[i][j]==0) return false;
            }
        }
        return true;
    }

}
