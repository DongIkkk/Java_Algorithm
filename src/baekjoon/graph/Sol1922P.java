package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Sol1922P {
    // Prim
    // 간선 클래스 - 시작,끝점, 가중치 생성자와 비교메서드 오버라이드
    static class Edge implements Comparable<Edge>{
        int start, end, w;

        public Edge(int start, int end, int w) {
            this.start = start;
            this.end = end;
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
        int v = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());

        // 노드마다 간선리스트 정보저장
        List<Edge>[] adjList = new ArrayList[v+1];
        for (int i = 1; i <= v ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[a].add(new Edge(a,b,weight));
            adjList[b].add(new Edge(b,a,weight));
        }

        boolean[] visited = new boolean[v+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        visited[1] = true;
        pq.addAll(adjList[1]);

        int pick = 1;
        long result = 0;

        while(pick != v){
            Edge edge = pq.poll();
            if(visited[edge.end]) continue;

            result += edge.w;
            pq.addAll(adjList[edge.end]);
            visited[edge.end] = true;
            pick++;
        }

        System.out.println(result);
    }
}
