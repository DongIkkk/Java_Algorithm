package DFSBFS;
import java.util.Scanner;
import java.util.Stack;

public class Sol1012 {
    static int M, N, K;
    static int[][] map;
    static int count;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tc = sc.nextInt();
        for (int tc = 1; tc <= Tc ; tc++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y][x] = 1;
            }

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1 && !visited[i][j]){
                        count++;
                        dfs(i,j);
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


            for(int i=0; i<4; i++){
                int nextx = next[0]+dx[i];
                int nexty = next[1]+dy[i];

                if(nextx>=0 && nextx<N && nexty>=0 && nexty<M){
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
