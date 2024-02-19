package implementation;

import java.util.Scanner;

public class Sol1652 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);

                if(c == 'X') {
                    map[i][j] = 1;
                }
            }
        }
        if(N==1) {
            System.out.print("0 0");
            return;
        }

        int w = 0;
        int l = 0;
        for (int i = 0; i < N; i++) {
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < N; j++) {
                if(map[i][j]==0) {
                    count1++;
                }

                if(map[i][j]==1 || j == N-1){
                    if(count1>=2) {
                        w++;
                    }
                    count1 = 0;
                }
            }
            for (int j = 0; j < N; j++) {
                if(map[j][i]==0) {
                    count2++;
                }

                if(map[j][i]==1 || j == N-1){
                    if(count2>=2) {
                        l++;
                    }
                    count2 = 0;
                }
            }
        }

        System.out.printf("%d %d", w, l);
    }
}
