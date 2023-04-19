package DFSBFS;

import java.io.*;
import java.util.*;


// 구글링함
public class Sol1520 {
    static int[][] map, memo;
    static int x, y;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new int[x][y];
        memo = new int[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                memo[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    // 현재 위치한 좌표로부터 목적지까지 갈 수 있는 방법이 몇개인가?
    // 목적지에 도달하면 1을 반환하는 dfs메서드를 이용

    static public int dfs(int r, int c){
        if(r==x-1 && c==y-1){
            return 1;
        }

        if(memo[r][c]!=-1) return memo[r][c];

        // -1과 구분하기 위해 dfs 돌릴땐 0으로 초기화 후 ㄱㄱ
        memo[r][c] = 0;
        for (int i = 0; i < 4; i++) {
            int nextx = r + dx[i];
            int nexty = c + dy[i];

            if(nextx<0 || nexty < 0 || nextx>=x || nexty >= y) continue;

            if(map[r][c] > map[nextx][nexty]){
                // 다음 좌표가 도달할 수 있다면
                // 반환된 값을 내 좌표에 저장
                memo[r][c] += dfs(nextx, nexty);
            }
        }
        // 내 좌표를 리턴 - 못간다면 위 line43에서 -1로 걸러졌을 것
        // 가는 길 없다면 0반환..
        return memo[r][c];
    }
}
