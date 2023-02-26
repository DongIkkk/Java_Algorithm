package implementation;

import java.util.Scanner;

public class Sol2567 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[102][102];

        int x, y;
        for(int i = 1; i<=N; i++){
            x=sc.nextInt();
            y=sc.nextInt();

            for(int j=x; j<x+10; j++){
                for(int k=y; k<y+10; k++){
                    map[j][k] = 1;
                }
            }
        }

        int[] searchx = {-1, 0, 1, 0};
        int[] searchy = {0, 1, 0, -1};

        int count=0;
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(map[i][j] == 1){
                    for(int k=0; k<4; k++){
                        if(map[i+searchx[k]][j+searchy[k]] == 0) count++;
                    }
                }
            }
        }
        System.out.println(count);

    }

}
