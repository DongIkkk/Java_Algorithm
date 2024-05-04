package DFSBFS;

import java.util.*;
import java.io.*;

public class Sol16469 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int[][][] nsc = new int[3][R][C];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int[] base = new int[] {Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1};

            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[R][C];
            nsc[i][base[0]][base[1]] = 1;
            visited[base[0]][base[1]] = true;
            q.add(base);
            while(!q.isEmpty()) {
                int[] now = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX = now[0] + dx[j];
                    int nextY = now[1] + dy[j];

                    if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;

                    if(map[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        nsc[i][nextX][nextY] = nsc[i][now[0]][now[1]] + 1;
                        visited[nextX][nextY] = true;
                        q.add(new int[] {nextX, nextY});
                    }
                }
            }
        }

        int min = 9999999;
        int count = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == 0 && nsc[0][i][j] > 0 && nsc[1][i][j] > 0 && nsc[2][i][j] > 0) {
                    int temp = Math.max(nsc[0][i][j], Math.max(nsc[1][i][j], nsc[2][i][j])) -1;
                    if(temp < min) {
                        min = temp;
                        count = 1;
                    } else if(temp == min) count++;
                }
            }
        }

        if(min == 9999999) {
            System.out.println(-1);
            return;
        }
        System.out.println(min);
        System.out.println(count);

    }
}
