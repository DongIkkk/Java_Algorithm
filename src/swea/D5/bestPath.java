package D5;

import java.util.Scanner;

public class bestPath {
    static int[][] map;
    static int N, result;
    static boolean[] visited;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            N = sc.nextInt();

            map = new int[N+2][2];

            for(int i=0; i<N+2; i++) {
                map[i][0] = sc.nextInt();
                map[i][1] = sc.nextInt();

            }

            visited = new boolean[N+2];
            result = Integer.MAX_VALUE;
            gogo(0, map[0][0], map[0][1], 0);
            System.out.printf("#%d %d\n", tc, result);

        }
    }

    public static void gogo(int idx, int x, int y, int distance) {
        if(distance > result) return;
        if(idx==N) {
            int temp = Math.abs(map[1][0] - x) + Math.abs(map[1][1] - y) + distance;
            if(temp<result) result = temp;
            return;
        }


        int xx = 0;
        int yy = 0;

        for(int i=2; i<N+2; i++) {
            if(!visited[i]) {
                xx = Math.abs(map[i][0] - x);
                yy = Math.abs(map[i][1] - y);

                visited[i]=true;

                gogo(idx+1, map[i][0], map[i][1], distance + xx + yy);

                visited[i]=false;
            }

        }

    }


}