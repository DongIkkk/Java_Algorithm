package D3;

import java.util.Scanner;

public class Sol7236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            int N = sc.nextInt();
            char[][] map = new char[N+2][N+2];

            for(int i=0; i<=N+1; i++){
                map[0][i] = 'G';
                map[N+1][i] = 'G';
                map[i][0] = 'G';
                map[i][N+1] = 'G';
            }

            for(int i=1; i<=N; i++){
                for (int j = 1; j <= N ; j++) {
                    map[i][j] = sc.next().charAt(0);
                }
            }

            int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

            int max = -1;
            int count=0;
            for(int i=1; i<=N; i++){
                for (int j = 1; j <= N ; j++) {
                    count=0;
                    for(int k=0; k<8; k++){
                        if (map[i+x[k]][j+y[k]] == 'W'){
                            count++;
                        }
                    }
                    if(count==0)count=1;
                    if(max<count) max=count;
                }
            }

            System.out.printf("#%d %d\n",tc,max);

        }
    }
}
