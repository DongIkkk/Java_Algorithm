package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol3584 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[] parents = new int[N+1];

            for (int j = 0; j < N-1; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parents[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            List<Integer> regX = new ArrayList<>();
            List<Integer> regY = new ArrayList<>();

            int temp = x;
            regX.add(x);

            while(true) {
                if(parents[x] == 0) break;

                regX.add(parents[x]);
                x = parents[x];
            }

            temp = y;
            regY.add(y);

            while(true) {
                if(parents[y] == 0) break;

                regY.add(parents[y]);
                y = parents[y];
            }

            for (int pp: regX) {
                if( regY.contains(pp)) {
                    System.out.println(pp);
                    break;
                }
            }

        }
    }
}
