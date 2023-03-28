package DFSBFS;

import java.util.*;

public class Sol2667 {
    static int n, count;
    static int[][] map;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static Stack<Integer> stack  = new Stack<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        //go
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]&&map[i][j]==1){
                    count=0;
                    dfs(i,j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(Integer n : result){
            System.out.println(n);
        }
    }

    public static void dfs(int x, int y){
        count++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dx[i];
            int nexty = y + dy[i];

            if(nextx>=0 && nexty>=0 && nextx<n && nexty<n){
                if(!visited[nextx][nexty] && map[nextx][nexty]==1){
                    dfs(nextx, nexty);
                }
            }
        }

    }

}
