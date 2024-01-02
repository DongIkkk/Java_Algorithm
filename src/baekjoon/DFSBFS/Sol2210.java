package DFSBFS;

import java.util.HashSet;
import java.util.Scanner;

public class Sol2210 {
    static int[][] map = new int[5][5];
    static HashSet<String> set = new HashSet<>();

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gogo(i,j,"",0);
            }
        }
        System.out.println(set.size());
    }

    static void gogo(int x, int y, String s, int isSix) {
        s += String.valueOf(map[x][y]);
        if(isSix == 5) {
            set.add(s);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx >= 0 && nextx < 5 && nexty>=0 && nexty < 5) {
                gogo(nextx, nexty, s, isSix+1);
            }
        }

    }
}
