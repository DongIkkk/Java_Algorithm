package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol13460 {
    static int x, y, rx, ry, bx, by, hx, hy;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();

        map = new char[x][y];

        for (int i = 0; i < x; i++) {
            String s = sc.next();
            for (int j = 0; j < y; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='R'){
                    rx = i;
                    ry = j;
                }
                if(map[i][j]=='B'){
                    bx = i;
                    by = j;
                }
                if(map[i][j]=='O'){
                    hx = i;
                    hy = j;
                }
            }
        }

        Queue<int[]> redQ = new LinkedList<>();
        redQ.add(new int[] {rx, ry, 0});
        Queue<int[]> blueQ = new LinkedList<>();
        blueQ.add(new int[] {bx, by});

        outer2:
        while(redQ.size()!=0){
            int[] now = redQ.poll();
            int nowrx = now[0];
            int nowry = now[1];

            if(now[2]>10){
                continue;
            }

            int[] nowb = blueQ.poll();
            int nowbx = nowb[0];
            int nowby = nowb[1];

            outer1:
            for (int i = 0; i < 4; i++) {

                while(true){

                    // 벽을 만날 때 까지

                    // 둘다 드갈때, 파란구슬만 들어갈때, 빨간구슬만 들어갈 때

                    // 아니라면 - 빨간구슬 파란구슬 겹치는 경우 위치 조정


                    nowrx += dx[i];
                    nowry += dy[i];
                    nowbx += dx[i];
                    nowby += dy[i];


                    if(map[nowrx][nowry]=='O'){
                        while(true){
                            nowrx-= dx[i];
                            nowry-= dy[i];
                            if(map[nowrx][nowry]=='B'){
                                continue outer1;
                            } else if (map[nowrx][nowry]=='#'){
                                System.out.println(now[2]+1);
                                return;
                            }
                        }
                    } else if(map[nowrx][nowry]=='#'){
                        redQ.add(new int[] {nowrx-dx[i], nowry-dy[i], now[2]+1});
                        map[rx][ry]='.';
                        rx = nowrx-dx[i];
                        ry = nowry-dy[i];
                        map[rx][ry]='R';
                        int tempx = nowrx-dx[i]-dx[i];
                        int tempy = nowry-dy[i]-dy[i];
                        while(true){
                            nowrx-= dx[i];
                            nowry-= dy[i];
                            if(map[nowrx][nowry]=='B'){
                                blueQ.add(new int[]{tempx, tempy});
                                map[bx][by]='.';
                                bx = tempx;
                                by = tempy;
                                map[bx][by]='B';
                                continue outer1;
                            } else if (map[nowrx][nowry]=='#'){
                                while(true){
                                    if(map[nowbx][nowby]=='O'){
                                        continue outer1;
                                    }else if(map[nowbx][nowby]=='#'){
                                        blueQ.add(new int[]{nowbx-dx[i], nowby-dy[i]});
                                        map[bx][by]='.';
                                        bx = nowbx-dx[i];
                                        by = nowby-dy[i];
                                        map[bx][by]='B';
                                    }
                                }
                            }
                        }
                    } else if(nowrx==nowbx && nowry==nowby){
                        redQ.add(new int[] {nowrx-dx[i], nowry-dy[i], now[2]+1});
                        map[rx][ry]='.';
                        rx = nowrx-dx[i];
                        ry = nowry-dy[i];
                        map[rx][ry]='R';
                        blueQ.add(new int[] {nowbx, nowby});
                        map[bx][by]='.';
                        bx = nowbx;
                        by = nowby;
                        map[bx][by]='B';
                    }

                    if(map[nowbx][nowby]=='O') continue outer1;

                }
            }
        }

        System.out.println(-1);

    }

}
