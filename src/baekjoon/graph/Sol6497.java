package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol6497 {
    static int n, m;
    static List<Node>[] adjList;

    static class Node implements Comparable<Node>{
        int start, end, w;

        public Node(int start, int end, int w){
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        outer:
        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0 && n==0){
                break outer;
            }

            adjList = new ArrayList[m+1];
            for (int i = 0; i <= m; i++) {
                adjList[i] = new ArrayList<>();
            }

            int sumAll = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());


                int z = Integer.parseInt(st.nextToken());

                sumAll += z;
                adjList[x].add(new Node(x, y, z));
                adjList[y].add(new Node(y, x, z));

            }

            boolean[] visited = new boolean[m+1];
            PriorityQueue<Node> pq = new PriorityQueue<>();


            visited[1] = true;
            pq.addAll(adjList[1]);

            int pick = 1;
            int result = 0;

            while(pq.size()!=0){
                Node node = pq.poll();
                if(visited[node.end]) continue;

                result +=  node.w;
                pq.addAll(adjList[node.end]);
                visited[node.end] = true;
                pick++;
                if(pick == m){
                    break;
                }
            }

            System.out.println(sumAll - result);

        }

    }
}
