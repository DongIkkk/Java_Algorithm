package D3;

import java.util.Scanner;

public class Sol2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];


            for(int i=0; i<N; i++) {
                String s = sc.next();
                String[] sarr = s.split("");
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(sarr[j]);
                }
            }
            int sum=0;
            for(int i=0; i<N; i++) {
                int start = Math.abs(i-N/2);
                int repeat = N - 2*start;
                for(int j=start; j<start+repeat; j++) {
                    sum+=map[i][j];
                }
            }

            System.out.printf("#%d %d\n",tc,sum);
        }
    }
}
