package D1_D2;

import java.util.Scanner;

public class Sol1979 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        //입력단
        int[][] puzzle = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                puzzle[i][j] = sc.nextInt();
            }
        }


//        0 0 1 1 1
//        1 1 1 0 0
//        1 0 0 1 1
//        1 0 0 0 1
//        0 1 1 1 1

    }
}
