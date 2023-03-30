package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol3124P {
    // Prim's Algorithm
    // 우선 순위 큐 이용

    static class Edge implements Comparable<Edge>{
        int stt, ed, w;

        public Edge(int stt, int ed, int w){
            this.stt = stt;
            this.ed = ed;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T ; tc++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<Edge>[] adjList = new ArrayList[v+1];

            for (int i = 1; i <= v; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int W = Integer.parseInt(st.nextToken());

                adjList[A].add(new Edge(A, B, W));
                adjList[B].add(new Edge(B, A, W));
            }

            boolean[] visited = new boolean[v+1];
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            // 시작 정점을 하나 뽑고 할래
            visited[1] = true;
            pq.addAll(adjList[1]);

            int pick = 1;
            long result = 0;

            while(pick != v){
                Edge edge = pq.poll();
                if(visited[edge.ed]) continue;

                result += edge.w;
                pq.addAll(adjList[edge.ed]);
                visited[edge.ed] = true;
                pick++;
            }
            System.out.printf("#%d %d\n", tc, result);

        }
    }
}
