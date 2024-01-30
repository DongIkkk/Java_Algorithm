package implementation;

import java.util.Scanner;

public class Sol1996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        char[][] map = new char[N][N];
        int[][] result = new int[N][N];

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};


        for (int i = 0; i < N; i++) {
            String s = sc.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] != '.') {
                    result[i][j] = -999;
                    int n = map[i][j] - '0';
                    for (int k = 0; k < 8; k++) {
                        if(i+dx[k] >= 0 && i+dx[k] < N && j+dy[k] >= 0 && j+dy[k] < N) {
                            result[i+dx[k]][j+dy[k]] += n;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if(result[i][j] < 0) {
                    sb.append('*');
                } else if(result[i][j] >= 10) {
                    sb.append('M');
                } else {
                    sb.append(result[i][j]);
                }
            }
            System.out.println(sb.toString());
        }
    }

}
