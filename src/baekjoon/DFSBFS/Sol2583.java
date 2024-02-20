package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol2583 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            draw(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> resultList = new ArrayList<>();

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0 && !visited[i][j]) {
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    int area = 0;
                    while(!q.isEmpty()) {
                        int[] now = q.poll();

                        area++;

                        for (int k = 0; k < 4; k++) {
                            int nextx = now[0] + dx[k];
                            int nexty = now[1] + dy[k];
                            if(nextx < 0 || nextx >= M || nexty < 0 || nexty >= N) continue;
                            if(map[nextx][nexty] == 0 && !visited[nextx][nexty]) {
                                q.add(new int[] {nextx, nexty});
                                visited[nextx][nexty] = true;
                            }
                        }
                    }

                    resultList.add(area);
                }
            }
        }

        Collections.sort(resultList);

        System.out.println(resultList.size());
        for (int n: resultList ) {
            System.out.printf("%d ", n);
        }
    }

    private static void draw(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i][j] = 1;
            }
        }
    }
}
