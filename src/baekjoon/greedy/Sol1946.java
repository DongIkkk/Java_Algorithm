package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[][] score = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i][0] = Integer.parseInt(st.nextToken());
                score[i][1] = Integer.parseInt(st.nextToken());

            }

            Arrays.sort(score, Comparator.comparingInt(o -> o[0]));

            int now = score[0][1];
            int next = Integer.MAX_VALUE;
            int count = 1;
            for (int i = 1; i < n ; i++) {
                next = score[i][1];
                if(next < now){
                    now = next;
                    count++;
                }
            }
            System.out.println(count);


        }
    }
}
