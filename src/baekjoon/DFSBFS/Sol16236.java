package DFSBFS;

// 아기상어
//더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
//먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
//먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
//거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
//거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

//0: 빈 칸
//1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
//9: 아기 상어의 위치

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol16236 {
    static int n, exp, result;
    static int sharklv = 2;
    static int[][] sea, distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int myx, myy; //지금 내위치
    static int movex, movey; // 이동할곳

    // 먹을 수 있는 물고기 담을 리스트
    static List<int[]> targetFish = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sea = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
                if(sea[i][j] == 9){
                    myx = i;
                    myy = j;
                }
            }
        }
        exp = 0;
        result = 0;
        // 1. 일단 내가 먹을 수 있는 물고기가 있는지
        outer:
        while(true){
            targetFish.clear();
            findTarget();
            if(targetFish.size() == 0) break;

            distanceCal(myx, myy);
            if(targetFish.size() == 1){
                // 지렷다 해종이형
                if(distance[targetFish.get(0)[0]][targetFish.get(0)[1]]==0) break;
                // !! 1마리일때 못가는경우 체크하지않음!!
                movex = targetFish.get(0)[0];
                movey = targetFish.get(0)[1];
                eat();
            } else{
                // 여러마리 먹어야 한다면?
                // 거리가 가장 가까운 놈 먼저
                int temp = Integer.MAX_VALUE;
                int eatcheck = 0;
                for(int[] fish:targetFish){
                    if(distance[fish[0]][fish[1]]==0) eatcheck++;
                    else if(temp > distance[fish[0]][fish[1]]){
                        movex = fish[0];
                        movey = fish[1];
                        temp = distance[fish[0]][fish[1]];
                    }
                }
                if(eatcheck == targetFish.size()) break outer;
                eat();
            }

        }

        System.out.println(result);


    }

    // 먹을 물고기 찾기 - 리스트에 좌표저장
    public static void findTarget(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sea[i][j] < sharklv && sea[i][j]!=9 && sea[i][j]>0){
                    targetFish.add(new int[] {i, j});
                }
            }
        }
    }

    // 입력받은 현재좌표로부터 모든 곳 거리계산
    public static void distanceCal(int x, int y){
        distance = new int[n][n];
        distance[x][y] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = temp[0] + dx[i];
                int nexty = temp[1] + dy[i];

                if(nextx>=0 && nexty>=0 && nextx<n && nexty<n){
                    if(distance[nextx][nexty]==0 && sea[nextx][nexty] <= sharklv && !(nextx==myx && nexty==myy)){
                        distance[nextx][nexty] = distance[temp[0]][temp[1]] + 1;
                        q.add(new int[] { nextx, nexty});
                    }
                }
            }
        }
    }

    public static void eat(){
        sea[myx][myy] = 0;
        result += distance[movex][movey];
        sea[movex][movey] = 0;
        exp++;
        if(exp == sharklv){
            sharklv++;
            exp = 0;
        }
        // 내위치변경
        myx = movex;
        myy = movey;
    }


}
