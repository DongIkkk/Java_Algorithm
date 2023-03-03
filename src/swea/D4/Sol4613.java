package D4;

import java.util.Scanner;

public class Sol4613 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            char[][] map = new char[N][M];
            for(int r=0; r<N; r++){
                String str = sc.next();
                map[r] = str.toCharArray();
            }

            int min = Integer.MAX_VALUE;

            for(int b=1; b<N-1; b++){
                for(int r=2; r<N; r++){
                    int count =0;
                    for(int i=0; i<N; i++){
                        for(int j=0; j<M; j++){
                            if(i<b && map[i][j]!='W') count++;
                            if(i>=b && i<r && map[i][j]!='B') count++;
                            if(i>=r && map[i][j]!='R') count++;
                        }
                    }
                    if(min>count) min = count;

                }
            }

            System.out.printf("#%d %d\n",tc,min);
        }
    }
}
