package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol1197 {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        p = new int[v+1];
        int[][] edges = new int[e][3];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 1; i <= v ; i++) {
            p[i] = i;
        }

        long result = 0;
        int pick = 0;
        for (int i = 0; i < e; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            if(findset(start) != findset(end)){
                union(start, end);
                result += edges[i][2];
                pick++;
            }
            if(pick == v-1) break;
        }
        System.out.println(result);

    }

    static int findset(int x){
        if(x!=p[x]) p[x] = findset(p[x]);
        return p[x];
    }

    static void union(int x, int y){
        p[findset(y)] = findset(x);
    }
}
