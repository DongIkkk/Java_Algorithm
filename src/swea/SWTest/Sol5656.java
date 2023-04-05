package SWTest;

import java.util.*;
import java.io.*;

public class Sol5656 {
    static int n, x, y; // n : 던지는 횟수 , x행, y열
    static int[][] map;
    static int temp, result, allcount;

    public static void main(String[] args) throws IOException {
        // 입력단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            map = new int[x][y];
            allcount = 0;
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0) allcount++;  // 전체 블록 개수
                }
            }
            result = 0;
            for (int i = 0; i < y; i++) {
                drop(map, i, 0, 0);
            }
            System.out.printf("#%d %d\n", tc, allcount - result);

        }
    }

    //                             현재맵    어디를깰지  지금까지몇개깸  몇번째인지
    public static void drop(int[][] inMap, int here, int kill, int 몇번부숨){

        if(몇번부숨 == n) {
            if(result < kill) result = kill;
            return;
        }

        // 맵 복사 현재 메서드에서 사용할 지도 thisMap
        int[][] thisMap = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                thisMap[i][j] = inMap[i][j];
            }
        }
        // 공던질 열에 던지면 누가맞는지
        // killx, here
        int killx = 0;
        for (int i = 0; i < x; i++) {
            if(thisMap[i][here] > 0){
                killx = i;
                break;
            }
        }
        // 블록부수기
        Queue<int[]> q = new LinkedList<>();
        // 부서졌는지 체크하는 배열
        boolean[][] bbrreeaakk = new boolean[x][y];
        q.add(new int[] {killx, here});
        bbrreeaakk[killx][here] = true;
        // 몇개부서졌는지
        int bbrrcount = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            int dmg = thisMap[nowx][nowy];

            thisMap[nowx][nowy] = 0;
            bbrrcount++;
            for (int i = 1; i < dmg; i++) {
                int nextx1 = nowx - i;
                int nexty1 = nowy;
                if(nextx1>=0 && thisMap[nextx1][nexty1]>0 && !bbrreeaakk[nextx1][nexty1]){
                    q.add(new int[] {nextx1, nexty1});
                    bbrreeaakk[nextx1][nexty1] = true;
                }

                int nextx2 = nowx + i;
                int nexty2 = nowy;
                if(nextx2<x && thisMap[nextx2][nexty2]>0 && !bbrreeaakk[nextx2][nexty2]){
                    q.add(new int[] {nextx2, nexty2});
                    bbrreeaakk[nextx2][nexty2] = true;
                }

                int nextx3 = nowx;
                int nexty3 = nowy - i;
                if(nexty3>=0 && thisMap[nextx3][nexty3]>0 && !bbrreeaakk[nextx3][nexty3]){
                    q.add(new int[] {nextx3, nexty3});
                    bbrreeaakk[nextx3][nexty3] = true;
                }

                int nextx4 = nowx;
                int nexty4 = nowy + i;
                if(nexty4 < y && thisMap[nextx4][nexty4]>0 && !bbrreeaakk[nextx4][nexty4]){
                    q.add(new int[] {nextx4, nexty4});
                    bbrreeaakk[nextx4][nexty4] = true;
                }

            }

        }
        if(kill+bbrrcount == allcount){
            result = kill+bbrrcount;
            return;
        }
        thisMap = gravity(thisMap);

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(thisMap[j][i] > 0){
                    drop(thisMap, i, kill + bbrrcount, 몇번부숨 + 1 );
                    break;
                }
            }
        }
    }

    public static int[][] gravity(int[][] inMap){
        int[][] outMap = new int[x][y];
        for (int j = 0 ; j < y; j++) {
            int idx = x-1;
            for (int i = x-1; i >= 0 ; i--) {
                if(inMap[i][j]>0) outMap[idx--][j] = inMap[i][j];
            }
        }
        return outMap;
    }

}
