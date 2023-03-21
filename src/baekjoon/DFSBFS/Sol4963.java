package DFSBFS;

import java.util.Scanner;
import java.util.Stack;

public class Sol4963 {
    static int[][] map;
    static boolean[][] visited ;
    static int w, h;
    static int count = 0;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Stack<int[]> stack = new Stack<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            h = sc.nextInt();
            w = sc.nextInt();

            if(w==0 && h==0) break;

            map = new int[w][h];
            visited = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            count = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        count++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(count);

        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        stack.push(new int[] {x, y});

        while(stack.size()!=0){
            int[] next = stack.pop();

            visited[next[0]][next[1]] = true;


            for(int i=0; i<8; i++){
                int nextx = next[0]+dx[i];
                int nexty = next[1]+dy[i];

                if(nextx>=0 && nextx<w && nexty>=0 && nexty<h){
                    if(map[nextx][nexty] == 1){
                        if(!visited[nextx][nexty]){
                            stack.push(new int[] {nextx, nexty});
                        }
                    }
                }

            }
        }


    }
}
