package graph;

import java.util.*;

public class Sol1753 {
    // dijkstra
    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] adjList;
    static int[] dist;
    static int v;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        int e = sc.nextInt();
        int k = sc.nextInt();

        adjList = new ArrayList[v+1];
        for (int i = 0; i <= v ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            adjList[u].add(new Node(to, w));
        }

        dist = new int[v+1];
        Arrays.fill(dist, INF);

        Dijkstra(k);

        for (int i = 1; i <= v ; i++) {
            if(dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }

    }

    public static void Dijkstra(int start){
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(visited[n.v]) continue;
            visited[n.v] = true;
            for(Node node : adjList[n.v]){
                if(dist[node.v] > n.w + node.w){
                    dist[node.v] = n.w + node.w;
                    pq.offer(new Node(node.v, dist[node.v]));
                }
            }
        }

    }
}
