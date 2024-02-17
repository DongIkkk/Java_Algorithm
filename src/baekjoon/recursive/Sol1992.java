package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1992 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];

        int ssss = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
                ssss += map[i][j];
            }
        }

        if(ssss == 0) {
            System.out.println(0);
            return;
        } else if( ssss == N*N) {
            System.out.println(1);
            return;
        }

        gogo(N, map);

        System.out.println(sb.toString());

    }

    static public void gogo(int l, int[][] map) {
        int now = l / 2;

        sb.append("(");

        int[][] newMap = new int[now][now];
        int check = 0;
        for (int i = 0; i < now; i++) {
            for (int j = 0; j < now; j++) {
                newMap[i][j] = map[i][j];
                check += map[i][j];
            }
        }
        if(check == 0) {
            sb.append(0);
        } else if(check == now * now) {
            sb.append(1);
        } else {
            gogo(now, newMap);
        }

        check = 0;
        for (int i = 0; i < now; i++) {
            for (int j = now; j < l; j++) {
                newMap[i][j-now] = map[i][j];
                check += map[i][j];
            }
        }
        if(check == 0) {
            sb.append(0);
        } else if(check == now * now) {
            sb.append(1);
        } else {
            gogo(now, newMap);
        }

        check = 0;
        for (int i = now; i < l; i++) {
            for (int j = 0; j < now; j++) {
                newMap[i-now][j] = map[i][j];
                check += map[i][j];
            }
        }
        if(check == 0) {
            sb.append(0);
        } else if(check == now * now) {
            sb.append(1);
        } else {
            gogo(now, newMap);
        }

        check = 0;
        for (int i = now; i < l; i++) {
            for (int j = now; j < l; j++) {
                newMap[i-now][j-now] = map[i][j];
                check += map[i][j];
            }
        }
        if(check == 0) {
            sb.append(0);
        } else if(check == now * now) {
            sb.append(1);
        } else {
            gogo(now, newMap);
        }

        sb.append(")");
    }
}
