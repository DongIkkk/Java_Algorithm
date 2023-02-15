package D1_D2;

import java.util.Scanner;

public class Sol1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N+2][N+2];

            int status = 1;
            // 우 1 하 2 좌 3 상 4
            int x = 1;
            int y = 1;
            for(int i=1; i<=N*N; i++) {
                if(status==1) {
                    map[x][y] = i;
                    if(map[x][y+1]!=0 || y==N) {
                        status = 2;
                        x++;
                    } else {
                        y++;
                    }
                } else if(status==2) {
                    map[x][y] = i;
                    if(map[x+1][y]!=0 || x==N) {
                        status = 3;
                        y--;
                    } else {
                        x++;
                    }
                } else if(status==3) {
                    map[x][y] = i;
                    if(map[x][y-1]!=0 || y==1) {
                        status = 4;
                        x--;
                    } else {
                        y--;
                    }
                } else if(status==4) {
                    map[x][y] = i;
                    if(map[x-1][y]!=0 || x==1) {
                        status = 1;
                        y++;
                    } else {
                        x--;
                    }
                }
            }


            System.out.println("#"+tc);
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    System.out.printf("%d ",map[i][j]);
                }
                System.out.println();
            }
        }
    }

}
