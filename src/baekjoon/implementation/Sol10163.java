package implementation;

import java.util.Scanner;

public class Sol10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[1001][1001];

        for (int i = 1; i <= N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            int c = sc.nextInt();

            for(int j=x; j<x+r; j++){
                for(int k=y; k<y+c; k++){
                    map[j][k] = i;
                }
            }
        }

        for(int i=1; i<=N; i++){
            int count=0;
            for(int j=0; j<1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if(map[j][k]==i)count++;
                }
            }
            System.out.println(count);
        }

    }
}
