package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2638 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] hp = new int[n][m]; // 한턴에 두변 만나면 킬

        int cheeseCnt=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j]==1) {
                    cheeseCnt++;
                    hp[i][j] = 2;
                }
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};
        Queue<int[]> q = new LinkedList<>();
        int second = 1;
        outer:
        while(true){
            visited = new boolean[n][m];
            q.clear();

            q.add(new int[] {0,0});
            visited[0][0] = true;

            while(q.size()!=0){
                int[] now = q.poll();
                int nowx = now[0];
                int nowy = now[1];

                for (int i = 0; i < 4; i++) {
                    int nextx = nowx + dx[i];
                    int nexty = nowy + dy[i];

                    if(nextx<0 || nexty<0 || nextx>=n || nexty>=m) continue;

                    if(map[nextx][nexty]==0 && !visited[nextx][nexty]){
                        q.add(new int[] {nextx, nexty});
                        visited[nextx][nexty] = true;
                    }

                    if(map[nextx][nexty]==1){
                        if(hp[nextx][nexty]==2){
                            hp[nextx][nexty]--;
                        } else{
                            hp[nextx][nexty]=2;
                            map[nextx][nexty]=0;
                            cheeseCnt--;
                            visited[nextx][nexty]=true;
                        }
                    }

                    if(cheeseCnt==0) {
                        break outer;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j]==1) hp[i][j]=2;
                }
            }
            second++;


        }
        System.out.println(second);


    }
}
