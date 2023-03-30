package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 창용 마을 무리의 개수
public class Sol7465 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            p = new int[N+1];
            int[][] edges = new int[M][2];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++){
                p[i] = i;
            }

            int pick = 0;
            for (int i = 0; i < M; i++) {
                int start = edges[i][0];
                int end = edges[i][1];

                if(findset(start) != findset(end)){
                    union(start,end);
                    pick++;
                }

                if(pick == N-1) break;
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                set.add(findset(i));
            }
            System.out.printf("#%d %d\n", tc, set.size());


        }
    }

    static int findset(int x){
        if(x!=p[x]) p[x] = findset(p[x]);
        return p[x];
    }

    static void union(int x, int y){
        p[findset(y)] = findset(x);
    }

    static void makeset(int x){
        p[x] = x;
    }
}
