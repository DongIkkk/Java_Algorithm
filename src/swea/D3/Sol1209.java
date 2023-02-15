package D3;

import java.util.Scanner;

public class Sol1209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int N = sc.nextInt();

            int[][] map = new int[100][100];

            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int sumrow;
            int sumcol;
            int sumequ = 0; //대각1
            int sumplu = 0; //대각2

            int max = -1;

            for(int i=0; i<100; i++) {
                sumrow = 0;
                sumcol = 0;
                for(int j=0; j<100; j++) {
                    sumrow += map[i][j];
                    sumcol += map[j][i];
                    if(i==j) sumequ+= map[i][j];
                    if(i+j == 99) sumplu+= map[i][j];
                }
                if(sumrow>max) max=sumrow;
                if(sumcol>max) max=sumcol;
            }

            if(sumequ>max) max=sumequ;
            if(sumplu>max) max=sumplu;

            System.out.printf("#%d %d\n", N, max);
        }
    }
}
