package graph;

import java.util.*;

public class Sol1916 {
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
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // city node
        m = sc.nextInt(); // bus edge
        adjList = new ArrayList[n+1];
        for (int i = 0; i <= n ; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            adjList[from].add(new Node(to, w));
        }

        dist = new int[n+1];
        Arrays.fill(dist, INF);

        int rsrt = sc.nextInt();
        int rend = sc.nextInt();
        Dijkstra(rsrt);

        System.out.println(dist[rend]);
    }

    public static void Dijkstra(int start){
        boolean[] visited = new boolean[n+1];
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
