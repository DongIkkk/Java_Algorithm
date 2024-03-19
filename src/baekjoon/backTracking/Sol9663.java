package backTracking;

import java.io.*;
import java.util.*;

public class Sol9663 {
    static int N, result;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        result = 0;
        Queen(0);

        System.out.println(result);

    }

    private static void Queen(int depth) {
        if(depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(check(i, depth) && map[depth][i] == 0) {
                map[depth][i] = 1;
                Queen(depth+1);
                map[depth][i] = 0;
            }
        }
    }

    private static boolean check(int x, int y) {
        int up = x, left = x-1, right = x+1;
        for (int i = y-1; i >= 0; i--) {
            if(map[i][up] == 1) return false;

            if(left >= 0 && map[i][left] == 1) {
                return false;
            }
            if(right < N && map[i][right] == 1) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
