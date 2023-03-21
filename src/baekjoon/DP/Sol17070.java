package DP;

import java.util.Scanner;

public class Sol17070 {
    static int N;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // status : 가로 1 세로 2 대각 3
        gopipe(0,1,1);
        System.out.println(count);
    }

    public static void gopipe(int x, int y, int status){
        if(x==N-1 && y==N-1){
            count++;
            return;
        }

        switch(status){
            case 1:
                if(y+1 < N && map[x][y+1] == 0) gopipe(x, y+1, 1 );
                if(x+1 < N && y+1 < N && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0) gopipe(x+1, y+1, 3);
                break;
            case 2:
                if(x+1 < N && map[x+1][y] == 0) gopipe(x+1, y, 2);
                if(x+1 < N && y+1 < N && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0) gopipe(x+1, y+1, 3);
                break;
            case 3:
                if(y+1 < N && map[x][y+1] == 0) gopipe(x, y+1, 1 );
                if(x+1 < N && y+1 < N && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0) gopipe(x+1, y+1, 3);
                if(x+1 < N && map[x+1][y] == 0) gopipe(x+1, y, 2);
                break;
        }

    }
}
