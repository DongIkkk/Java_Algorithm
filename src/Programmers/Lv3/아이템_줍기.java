package Lv3;

import java.util.*;

public class 아이템_줍기 {
    static int[] dx = {-1, 0, 1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1, 0, 1};
    static int[][] map;
    static int startx, starty, goalx, goaly, total, tempCount;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        startx = characterX;
        starty = characterY;
        goalx = itemX;
        goaly = itemY;
        map = new int[52][52];

        for (int i = 0; i < rectangle.length; i++) {
            int[] temp = rectangle[i];
            for (int j = temp[0]; j < temp[2]; j++) {
                for (int k = temp[1]; k < temp[3]; k++) {
                    map[j][k] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[52][52];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0,0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            map[now[0]][now[1]] = 2;

            for (int i = 0; i < 4; i++) {
                int nextx = now[0] + dx[i];
                int nexty = now[1] + dy[i];
                if(nextx <= 51 && nexty <= 51 && nextx >= 0 && nexty >= 0) {
                    if(map[nextx][nexty] == 0 && !visited[nextx][nexty]) {
                        visited[nextx][nexty] = true;
                        q.add(new int[] {nextx, nexty});
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if(map[characterX][characterY] != map[characterX-1][characterY]) {
                // 위로갈 수 있다
                gogo(characterX, characterY+1, 0, 1);
            } else if(map[characterX][characterY] != map[characterX][characterY-1]) {
                // 오른쪽으로 갈 수 있다
                gogo(characterX+1, characterY, 1, 1);
            } else if(map[characterX][characterY-1] != map[characterX-1][characterY-1]){
                // 아래로 갈 수 있다
                gogo(characterX, characterY-1, 2, 1);
            } else if(map[characterX-1][characterY] != map[characterX-1][characterY-1]){
                // 왼쪽으로 갈 수 있다.
                gogo(characterX-1, characterY, 3, 1);
            }
        }

        return Math.min(tempCount, total-tempCount);
    }

    static public void gogo(int x, int y, int dir, int count) {
        if(x == goalx && y == goaly) tempCount = count;
        if( x == startx && y == starty) {
            total = count;
            return;
        }
        // 0 하상 1좌우 2상하 3우좌
        switch (dir) {
            case 0:
                if(map[x][y] != map[x-1][y]) gogo(x, y+1, 0, count+1);
                else if(map[x][y] != map[x][y-1]) gogo(x+1, y, 1, count+1);
                else if(map[x-1][y] != map[x-1][y-1]) gogo(x-1, y, 3, count+1);
                break;
            case 1:
                if(map[x][y] != map[x-1][y]) gogo(x, y+1, 0,count+1);
                else if(map[x][y] != map[x][y-1]) gogo(x+1, y, 1, count+1);
                else if(map[x][y-1] != map[x-1][y-1]) gogo(x, y-1, 2, count+1);
                break;
            case 2:
                if(map[x][y] != map[x][y-1]) gogo(x+1, y, 1, count+1);
                else if(map[x][y-1] != map[x-1][y-1]) gogo(x, y-1, 2, count+1);
                else if(map[x-1][y] != map[x-1][y-1]) gogo(x-1, y, 3, count+1);
                break;
            case 3:
                if(map[x][y] != map[x-1][y]) gogo(x, y+1, 0, count+1);
                else if(map[x][y-1] != map[x-1][y-1]) gogo(x, y-1, 2,count+1);
                else if(map[x-1][y] != map[x-1][y-1]) gogo(x-1, y, 3, count+1);
                break;
        }
    }

}
