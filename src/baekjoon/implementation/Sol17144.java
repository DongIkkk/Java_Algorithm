package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol17144 {
    static int R, C, T;
    static int[][] map;
    static int[][] newMap;
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, 1, 0, -1, 0};

    static int up, down;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && up > 0) {
                    down = i;
                } else if(map[i][j] == -1) up = i;
            }
        }
        int time = 1;
        while(time <= T) {
            int dif, nextx, nexty;
            newMap = new int[R+1][C+1];
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if(map[i][j] > 0) {
                        newMap[i][j] += map[i][j];
                        dif = map[i][j]/5;

                        for (int k = 0; k < 5; k++) {
                            nextx = i + dx[k];
                            nexty = j + dy[k];
                            if(nextx < 1 || nexty < 1 || nextx > R || nexty > C || map[nextx][nexty] == -1){
                                continue;
                            } else {
                                newMap[nextx][nexty] += dif;
                                newMap[i][j] -= dif;
                            }
                        }
                    } else {
                        map[i][j] += newMap[i][j];
                    }
                }
            }

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    map[i][j] = newMap[i][j];
                }
            }

            gogo();

            time++;
        }

        int result = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result+2);

    }

    private static void gogo() {
        int x = up-1;
        int y = 1;
        int nextx, nexty;
        int dir = 4;
        while(true) {
            nextx = x + dx[dir];
            nexty = y + dy[dir];

            if(x == up && y == 1) break;

            if(nextx < 1 || nextx > up || nexty < 1 || nexty > C) {
                dir++;
                if(dir == 5) dir = 1;
                continue;
            }

            map[x][y] = map[nextx][nexty];
            x = nextx;
            y = nexty;
        }
        map[up][1] = -1;

        dir = 2;
        x = down + 1;
        y = 1;
        while (true) {
            nextx = x + dx[dir];
            nexty = y + dy[dir];

            if(x == down && y == 1) break;

            if(nextx <= up || nextx > R || nexty < 1 || nexty > C) {
                dir--;
                if(dir == 0) dir = 4;
                continue;
            }

            map[x][y] = map[nextx][nexty];
            x = nextx;
            y = nexty;
        }
        map[down][1] = -1;
    }
}
