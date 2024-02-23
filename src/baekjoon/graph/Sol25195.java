package graph;

import java.util.*;
import java.io.*;

public class Sol25195 {
    static int N, M;
    static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
    static ArrayList<Integer> fans = new ArrayList<>();
    static boolean result = true;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < f; i++) {
            fans.add(Integer.parseInt(st.nextToken()));
        }

        if(!fans.contains(1)) {
            dfs(1, false);
        }

        if(result) System.out.println("Yes");
        else System.out.println("yes");

    }

    private static void dfs(int node, boolean check) {
        ArrayList<Integer> next = graph.get(node);

        if(next.isEmpty()) {
            if(!check) result = false;
            return;
        }

        for(int n : next){
            if(!fans.contains(n)) dfs(n, false);
        }
    }
}
