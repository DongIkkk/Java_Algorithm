package implementation;

import java.util.*;

public class Sol15685 {
    static int N;
    static int[][] map = new int[101][101];

    /*
        0: x 좌표가 증가하는 방향 (→)
        1: y 좌표가 감소하는 방향 (↑)
        2: x 좌표가 감소하는 방향 (←)
        3: y 좌표가 증가하는 방향 (↓)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            int x = sc.nextInt();
            int y = sc.nextInt();    // 시작점 x,y좌표
            int d = sc.nextInt();   // 방향
            int g = sc.nextInt();

            map[x][y] = 1;
            switch (d) {
                case 0:
                    map[++x][y] = 1;
                    break;
                case 1:
                    map[x][--y] = 1;
                    break;
                case 2:
                    map[--x][y] = 1;
                    break;
                case 3:
                    map[x][++y] = 1;
                    break;
            }

            q.add((d+1) % 4);

            for (int j = 1; j <= g; j++) {
                for (int dir: q) {
                    switch (dir) {
                        case 0:
                            map[++x][y] = 1;
                            break;
                        case 1:
                            map[x][--y] = 1;
                            break;
                        case 2:
                            map[--x][y] = 1;
                            break;
                        case 3:
                            map[x][++y] = 1;
                            break;
                    }
                    temp.add(dir);
                }
                q.clear();

                for (int k = temp.size()-1; k >= 0; k--) {
                    q.add((temp.get(k)+1) % 4);
                }
                q.addAll(temp);
                temp.clear();

            }
        }
        int result = 0;
        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                if(map[j][k] == 1 && map[j+1][k] == 1 && map[j][k+1] == 1 && map[j+1][k+1] == 1) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
