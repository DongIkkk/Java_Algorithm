package DFSBFS;

import java.io.*;
import java.util.*;

public class Sol16173 {
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 2; i++) {
                int nextX = now[0] + dx[i] * map[now[0]][now[1]];
                int nextY = now[1] + dy[i] * map[now[0]][now[1]];

                if(nextX >= N || nextY >= N ) continue;

                if(!visited[nextX][nextY]) {
                    q.add(new int[] {nextX, nextY});
                }
            }
        }

        if(visited[N-1][N-1]) System.out.print("HaruHaru");
        else System.out.print("Hing");
    }
}
