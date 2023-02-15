package D4;

import java.util.Scanner;

public class Sol1210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int N = sc.nextInt();

            int[][] ladder = new int[100][100];

            for(int i=0; i<100; i++) {
                for(int j=0; j<100; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }

            //현재좌표
            int nowx = 99;
            int nowy = 99;

            for(int i=0; i<100; i++) {
                if(ladder[99][i] == 2) nowy = i;
            }
            // 현재상태 방향
            // 1 위로가던중 2좌 3우
            int status = 1;
            while(nowx>0) {
                if(status == 1) {

                    if(nowy-1>=0 &&ladder[nowx][nowy-1]==1) {
                        nowy--;
                        status = 2;

                    } else if(nowy+1<=99 &&ladder[nowx][nowy+1]==1) {
                        nowy++;
                        status = 3;
                    } else {
                        nowx--;
                    }
                }

                else if(status == 2) {
                    if(ladder[nowx-1][nowy]==1) {
                        nowx--;
                        status = 1;
                    } else {
                        nowy--;
                    }
                }

                else if(status == 3) {
                    if(ladder[nowx-1][nowy]==1) {
                        nowx--;
                        status = 1;
                    } else {
                        nowy++;
                    }
                }
            }

            System.out.printf("#%d %d\n", N, nowy);

        }
    }

}
