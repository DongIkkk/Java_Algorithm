package DFSBFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1260 {
    // n 노드 m 간선 v 루트
    static int n, m, v;
    static List<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new List[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(n2);
            graph[n2].add(n1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v);
        System.out.println();

        visited = new boolean[n+1];

        bfs(v);
        System.out.println();



    }


    public static void dfs(int node){
        visited[node] = true;
        System.out.printf("%d ",node);

        for(int nextnode : graph[node]){
            if(!visited[nextnode]){
                dfs(nextnode);
            }
        }

    }

    public static void bfs(int node){
        visited[node] = true;
        System.out.printf("%d ", node);
        q.add(node);

        while(!q.isEmpty()){
            int tempNode = q.poll();
            for(int nextnode : graph[tempNode]){
                if(!visited[nextnode]){
                    visited[nextnode] = true;
                    System.out.printf("%d ", nextnode);
                    q.add(nextnode);
                }
            }
        }


    }
}
