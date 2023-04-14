package graph;

import java.io.*;
import java.util.*;

public class Sol1238 {

    static class Node implements Comparable<Node>{
        // 도착지와 가중치
        int v,w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static List<Node>[] adjList;
    static int[] dist;
    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 노드
        int M = Integer.parseInt(st.nextToken()); // 간선
        X = Integer.parseInt(st.nextToken()); // 파티마을


        adjList = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, weight));
        }


        int max = -1;
        for (int i = 1; i <= N; i++) {
            int temp = Dijkstra(i, X);
            temp += Dijkstra(X, i);
            if(max < temp){
                max = temp;
            }
        }

        System.out.println(max);

    }

    public static int Dijkstra(int start, int end) {
        if(start==end) return 0;
        boolean[] visited = new boolean[N + 1];
        dist = new int[N+1];
        Arrays.fill(dist, 987654321);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            if (visited[n.v]) continue;
            visited[n.v] = true;
            for (Node node : adjList[n.v]) {
                if (dist[node.v] > n.w + node.w) {
                    dist[node.v] = n.w + node.w;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }
        return dist[end];
    }
}

