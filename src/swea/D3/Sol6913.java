package D3;

import java.util.Scanner;

public class Sol6913 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][M];
            int[] score = new int[N];
            for(int i=0; i<N; i++) {
                int sum = 0;
                for(int j=0; j<M; j++) {
                    arr[i][j] = sc.nextInt();
                    sum += arr[i][j];
                }
                score[i] = sum;
            }

            int max = -1;
            for(int num:score) {
                if(num>max) max=num;
            }

            int count = 0;
            for(int num:score) {
                if(num == max) count++;
            }

            System.out.printf("#%d %d %d\n",tc, count, max);
        }
    }
}
