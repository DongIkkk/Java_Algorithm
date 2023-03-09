package DFSBFS;

import java.util.*;

public class Sol2644 {
    static List<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int find1 = sc.nextInt();
        int find2 = sc.nextInt();
        graph = new ArrayList[node+1];
        visited = new boolean[node+1];
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        int edge = sc.nextInt();
        for(int i=0; i<edge; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();

            graph[parent].add(child);
            graph[child].add(parent);
        }


        System.out.println(BFS(find1, find2));

    }

    static public int BFS(int start, int end){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int[] check = new int[graph.length+1];

        while(q.size()>0){
            int num = q.poll();

            if(num == end){
                return check[num];
            }

            for (int i = 0; i < graph[num].size(); i++) {
                int next = graph[num].get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    check[next] = check[num]+1;
                }
            }
        }
        return -1;
    }
}
