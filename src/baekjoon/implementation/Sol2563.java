package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Sol2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[100][100];

        int[][] paper = new int[N][2];

        for(int i=0; i<N; i++) {
            for(int j=0; j<2; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++) {
            int x = paper[i][0];
            int y = paper[i][1];
            for(int j=x; j<x+10; j++) {
                for(int k=y; k<y+10; k++) {
                    map[j][k] = 1;
                }
            }
        }

        int sum = 0;

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }
}
