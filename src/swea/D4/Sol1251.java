package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol1251 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] xarr = new int[n];
            int[] yarr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                xarr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                yarr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            double e = Double.parseDouble(st.nextToken());

            p = new int[n+1];

            int ki = n*(n-1) / 2;
            long[][] edges = new long[ki][3];
            int idx = 0;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    long weight = (long) (Math.pow((xarr[i] - xarr[j]), 2) + Math.pow((yarr[i] - yarr[j]), 2));
                    edges[idx][0] = i+1;
                    edges[idx][1] = j+1;
                    edges[idx++][2] = weight;
                }
            }

            Arrays.sort(edges, new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o1[2], o2[2]);
                }
            });

            for (int i = 0; i <= n ; i++) {
                p[i] = i;
            }

            long result = 0;
            int pick = 0;
            for (int i = 0; i < ki; i++) {
                long start = edges[i][0];
                long end = edges[i][1];

                if(findset(start) != findset(end)){
                    union(start, end);
                    result += edges[i][2];
                    pick++;
                }
                if(pick == n-1) break;
            }
            double cresult = result * e;
            System.out.printf("#%d %.0f\n", tc, cresult);

        }
    }

    static long findset(long x){
        if(x!=p[(int) x]) p[(int) x] = (int) findset(p[(int) x]);
        return p[(int) x];
    }

    static void union(long x, long y){
        p[(int) findset(y)] = (int) findset(x);
    }
}
