package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol2636 {
    static int X, Y, count;
    static int[][] map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[X][Y];

        for (int i = 0; i < X; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int time = 0;
        int resultCount = 0;
        while(isEnd()){
            BFS();
            time++;
            resultCount = count;
        }

        System.out.println(time);
        System.out.println(resultCount);

    }

    static public void BFS(){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[X][Y];
        q.add(new int[] {0,0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(map[now[0]][now[1]] == 1) {
                map[now[0]][now[1]] = 0;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if(nextX < 0 || nextX >= X || nextY < 0 || nextY >= Y) continue;

                if(!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    static public boolean isEnd() {
        count = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if(map[i][j] == 1) count++;
            }
        }
        return count > 0;
    }
}
