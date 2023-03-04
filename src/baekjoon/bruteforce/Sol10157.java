package bruteforce;

import java.util.Scanner;

public class Sol10157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] map = new int[r+2][c+2];
        int me = sc.nextInt();
        int x=1, y=1, i=1;

        // 위 1 우 2 하 3 좌 4
        int status = 1;
        if(me > r*c) System.out.println(0);
        else {
            while (i < me) {
                map[x][y] = i;
                switch (status) {
                    case 1:
                        if (y + 1 <= c && map[x][y+1] == 0) {
                            y++;
                        } else {
                            status = 2;
                            x++;
                        }
                        break;
                    case 2:
                        if (x + 1 <= r && map[x+1][y] == 0) {
                            x++;
                        } else {
                            status = 3;
                            y--;
                        }
                        break;
                    case 3:
                        if (y - 1 >= 1 && map[x][y-1] == 0) {
                            y--;
                        } else {
                            status = 4;
                            x--;
                        }
                        break;
                    case 4:
                        if (x - 1 >= 1 && map[x-1][y] == 0) {
                            x--;
                        } else {
                            status = 1;
                            y++;
                        }
                }
                i++;
            }
            System.out.printf("%d %d",x, y);
        }


    }
}
