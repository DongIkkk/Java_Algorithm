package implementation;

import java.util.Scanner;

public class Sol2669 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] map = new int[101][101];
        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int j = x1; j < x2; j++) {
                for (int k = y1; k < y2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                result += map[i][j];
            }
        }
        System.out.println(result);
    }
}
