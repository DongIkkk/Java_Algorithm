package DFSBFS;

import java.util.Scanner;
import java.util.Stack;

public class Sol10026 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count1;
    static int count2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i <  N ; i++) {
            String s = sc.next();
            map[i] = s.toCharArray();
        }

        count1 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    count1++;
                    dfs(i, j, map[i][j]);
                }
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }

        count2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count2++;
                    dfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(count1 + " " + count2);

    }

    public static void dfs(int x, int y, char c){

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x,y});

        while(stack.size()!=0){
            int[] now = stack.pop();
            visited[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nextx = now[0]+dx[i];
                int nexty = now[1]+dy[i];

                if(nextx < N && nexty <N && nextx>=0 && nexty>=0){
                    if(map[nextx][nexty] == c && !visited[nextx][nexty]){
                        stack.push(new int[]{nextx, nexty});
                    }
                }
            }
        }

    }
}
