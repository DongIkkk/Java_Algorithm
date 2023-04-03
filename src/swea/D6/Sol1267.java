package D6;

import java.io.*;
import java.util.*;

public class Sol1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10 ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new ArrayList[v+1];

            for (int i = 0; i <= v ; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] inDegree = new int[v+1];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < e; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                inDegree[b]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= v; i++) {
                if(inDegree[i] == 0){
                    q.add(i);
                }
            }
            System.out.printf("#%d ", tc);
            while(!q.isEmpty()){
                int node = q.poll();
                System.out.printf("%d ", node);

                for(int next : graph[node]){
                    inDegree[next]--;
                    if(inDegree[next] == 0){
                        q.add(next);
                    }
                }
            }
            System.out.println();

        }
    }
}
