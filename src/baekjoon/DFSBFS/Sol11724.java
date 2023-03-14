package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol11724 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            set.add(i);
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        int result = 0;
        for (int i = 1; i <= N ; i++) {
            if(set.contains(i)){
                result++;
                dfs(i);
            }
        }

        System.out.println(result);
    }

    public static void dfs(int start){
        set.remove(start);

        for(int node:graph[start]){
            if(set.contains(node)){
                dfs(node);
            }
        }
    }

}