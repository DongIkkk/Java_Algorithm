package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sol4386 {
    static class Edge implements Comparable<Edge>{
        int start, end;
        double w;
        public Edge(int start, int end, double w){
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return this.w - o.w < 0 ? -1 : 1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[][] stars = new double[n][2];

        for (int i = 0; i < n; i++) {
            stars[i][0] = sc.nextDouble();
            stars[i][1] = sc.nextDouble();
        }

        List<Edge>[] adjList = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            for (int j = i+1; j < n; j++) {
                double weight = Math.sqrt(Math.pow((stars[i][0] - stars[j][0]), 2) + Math.pow((stars[i][1] - stars[j][1]), 2));

                adjList[i+1].add(new Edge(i+1, j+1, weight));
                adjList[j+1].add(new Edge(j+1, i+1, weight));

            }
        }

        boolean[] visited = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        visited[1] = true;
        pq.addAll(adjList[1]);

        int pick = 1;
        double result = 0;

        while(pick != n){
            Edge edge = pq.poll();
            if(visited[edge.end]) continue;

            result += edge.w;
            pq.addAll(adjList[edge.end]);
            visited[edge.end] = true;
            pick++;
        }

        System.out.printf("%.2f",result);
    }
}
