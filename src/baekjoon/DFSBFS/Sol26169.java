package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol26169 {
    static boolean check;
    static int[][] map = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startx = Integer.parseInt(st.nextToken());
        int starty = Integer.parseInt(st.nextToken());
        visited[startx][starty] = true;
        dfs(0, startx, starty, 0);

        System.out.print(check ? 1 : 0);
    }

    public static void dfs(int count, int nowX, int nowY, int apple){
        if(map[nowX][nowY] == 1) apple++;

        if(apple >= 2) {
            check = true;
            return;
        }
        if(count == 3) return;

        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            if(nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5) continue;

            if(map[nextX][nextY] != -1 && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;
                dfs(count + 1, nextX, nextY, apple);
                visited[nextX][nextY] = false;
            }
        }
    }
}
