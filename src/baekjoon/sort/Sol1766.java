package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] zz = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            zz[i] = new ArrayList<>();
        }
        int[] indegree = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            zz[f].add(l);
            indegree[l]++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            if(indegree[i]==0){
                pq.add(i);
            }
        }


        while(pq.size()!=0){
            int now = pq.poll();
            sb.append(now);
            sb.append(" ");

            for(int next:zz[now]){
                indegree[next]--;
                if(indegree[next]==0){
                    pq.add(next);
                }
            }
        }

        System.out.println(sb.toString());

    }

}
