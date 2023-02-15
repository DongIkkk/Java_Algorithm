package D1_D2;

import java.util.Scanner;

public class Sol1961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {

            int N = sc.nextInt();
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int[][] arr90 = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr90[i][j] = map[N-1-j][i];
                }
            }

            int[][] arr180 = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr180[i][j] = arr90[N-1-j][i];
                }
            }

            int[][] arr270 = new int[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr270[i][j] = arr180[N-1-j][i];
                }
            }
            System.out.println("#"+tc);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.printf("%d",arr90[i][j]);
                }
                System.out.print(" ");
                for(int j=0; j<N; j++) {
                    System.out.printf("%d",arr180[i][j]);
                }
                System.out.print(" ");
                for(int j=0; j<N; j++) {
                    System.out.printf("%d",arr270[i][j]);
                }
                System.out.println();
            }
        }


    }
}
