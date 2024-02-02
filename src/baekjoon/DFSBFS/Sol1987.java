package DFSBFS;

import java.util.*;
import java.io.*;

public class Sol1987 {
    static int R, C;
    static char[][] map;
    static List<Character> visited = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int resultMax = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = sc.next();
            map[i] = s.toCharArray();
        }

        dfs(0, 0);
        System.out.println(resultMax);
    }

    static void dfs(int x, int y) {
        visited.add(map[x][y]);
        resultMax = Math.max(visited.size(), resultMax);

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx >= 0 && nexty >= 0 && nextx < R && nexty <C && !visited.contains(map[nextx][nexty])) {
                dfs(nextx, nexty);
            }
        }
        visited.remove(visited.indexOf(map[x][y]));
    }
}
