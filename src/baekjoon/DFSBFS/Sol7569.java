package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class Sol7569 {
    static int x, y, z, result;
    static int[][][] tomato;
    static Queue<int[]> q = new LinkedList<>();

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());
        tomato = new int[z][x][y];

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < y; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k]==1){
                        q.add(new int[] {i,j,k});
                    }
                }
            }
        }

        if(tmtCheck()) {
            System.out.println(0);
            return;
        }

        while(!q.isEmpty()){
            int[] temp = q.poll();
            for (int i = 0; i < 6; i++) {
                int nextz = temp[0] + dz[i];
                int nextx = temp[1] + dx[i];
                int nexty = temp[2] + dy[i];

                if(nextz>=0 && nextx>=0 && nexty>=0 && nextz<z && nextx<x && nexty<y){
                    if(tomato[nextz][nextx][nexty]==0 || tomato[nextz][nextx][nexty] > tomato[temp[0]][temp[1]][temp[2]] + 1){
                        tomato[nextz][nextx][nexty] = tomato[temp[0]][temp[1]][temp[2]] + 1;
                        q.add(new int[] {nextz, nextx, nexty});
                    }
                }
            }
        }


        result = -1;
        if(!tmtCheck()){
            System.out.println(-1);
        } else{
            System.out.println(result-1);
        }
    }

    static public boolean tmtCheck(){
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < y; k++) {
                    if(result < tomato[i][j][k]) result = tomato[i][j][k];
                    if(tomato[i][j][k]==0) return false;

                }
            }
        }
        return true;
    }
}
