package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] parents = new int[N+1];
        parents[1] = 1;

        List<Integer>[] list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int temp = q.poll();

            for(int i: list[temp]) {
                if(parents[i] == 0) {
                    parents[i] = temp;
                    q.add(i);
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }
}
