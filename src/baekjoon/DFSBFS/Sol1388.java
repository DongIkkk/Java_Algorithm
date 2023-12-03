package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j) == '-') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        int count0 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    count0++;
                    if(j+1<m && map[i][j+1]==0) {
                        count0--;
                    }
                }
            }
        }
        int count1 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[j][i] == 1){
                    count1++;
                    if(j+1<n && map[j+1][i]==1) {
                        count1--;
                    }
                }
            }
        }
        System.out.println(count0 + count1);

    }
}
