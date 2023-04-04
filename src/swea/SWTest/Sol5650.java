package SWTest;

import java.io.*;
import java.util.*;

//블랙홀 -1  여러개일 수 있음
//빈공간 0
//블록 1~5
//웜홀 6~10 쌍으로주어짐

public class Sol5650 {
    static int N;
    static int[][] map;
    static int myx, myy, whx, why;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            N = sc.nextInt();
            map = new int[N+2][N+2];
            Arrays.fill(map[0], 5);
            Arrays.fill(map[N+1], 5);
            for (int i = 0; i < N+2; i++) {
                map[i][0] = 5;
                map[i][N+1] = 5;
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            // 1번블록 오른쪽으로   3,4
            // 1번블록 위쪽으로    2,3

            // 2번블록 오른쪽으로 3,4
            // 2번블록 아래쪽으로 1,4

            // 3번블록 왼쪽으로 1,2
            // 3번블록 아래쪽으로 1,4

            // 4번블록 왼쪽으로 1,2
            // 4번블록 위쪽으로 2,3

            // 그와중에 블랙홀 만나면 끝
            // 그와중에 웜홀 만나면 바꿔주기

            // 오른쪽 0 왼쪽 1 위쪽 2, 아래쪽 3

            int result = Integer.MIN_VALUE;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int temp = 0;
                    if(map[i][j] == 0) {
                        myx = i;
                        myy = j;
                        temp = gogo(0, i, j, 0, 3, 4);
                        if (result < temp) result = temp;
                        temp = gogo(0, i, j, 1, 1, 2);
                        if (result < temp) result = temp;
                        temp = gogo(0, i, j, 2, 2, 3);
                        if (result < temp) result = temp;
                        temp = gogo(0, i, j, 3, 1, 4);
                        if (result < temp) result = temp;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, result);

        }
    }

    // 오른쪽 0 왼쪽 1 위쪽 2, 아래쪽 3
    static public int gogo(int count, int x, int y, int status, int find1, int find2){
//        if(count>=1 && x==myx && y == myy) return count;
//        System.out.printf("(%d,%d) / x : %d, y: %d, stat: %d, count : %d\n",myx, myy, x, y, status, count);
        switch (status){
            case 0:
                //y증가.
                for(int i = y+1; i<=N+1; i++ ){

                    if(x==myx && i == myy) return count;

                    if(map[x][i] == find1){
                        return gogo(count + 1, x, i, 3, 1, 4);
                    } else if(map[x][i] == find2){
                        return gogo(count + 1, x, i, 2, 2, 3);
                    } else if(map[x][i] == -1){
                        return count;
                    } else if(map[x][i] >= 6){
                        findwh(map[x][i], x, i);
                        return gogo(count, whx, why, status, find1, find2);
                    } else if(map[x][i]>0){
                        return gogo(count+1, x, i, 1, 1, 2);
                    }
                }
            case 1:
                //y감소
                for(int i = y-1; i>=0; i-- ){

                    if(x==myx && i == myy) return count;

                    if(map[x][i] == find1){
                        return gogo(count + 1, x, i, 2, 2, 3);
                    } else if(map[x][i] == find2){
                        return gogo(count + 1, x, i, 3, 1, 4);
                    } else if(map[x][i] == -1){
                        return count;
                    } else if(map[x][i] >= 6){
                        findwh(map[x][i], x, i);
                        return gogo(count, whx, why, status, find1, find2);
                    } else if(map[x][i]>0){
                        return gogo(count+1, x, i, 0, 3, 4);
                    }
                }
            case 2:
                //x감소
                for(int i = x-1; i>=0; i-- ){
                    if(i==myx && y == myy) return count;
                    if(map[i][y] == find1){
                        return gogo(count + 1, i, y, 0, 3, 4);
                    } else if(map[i][y] == find2){
                        return gogo(count + 1, i, y, 1, 1, 2);
                    } else if(map[i][y] == -1){
                        return count;
                    } else if(map[i][y] >= 6){
                        findwh(map[i][y], i, y);
                        return gogo(count, whx, why, status, find1, find2);
                    }else if(map[i][y]>0){
                        return gogo(count+1, i, y, 3, 1, 4);
                    }
                }
            case 3:
                // x증가
                for(int i = x+1; i<=N+1; i++ ){
                    if(i==myx && y == myy) return count;
                    if(map[i][y] == find1){
                        return gogo(count + 1, i, y, 0, 3, 4);
                    } else if(map[i][y] == find2){
                        return gogo(count + 1, i, y, 1, 1, 2);
                    } else if(map[i][y] == -1){
                        return count;
                    } else if(map[i][y] >= 6){
                        findwh(map[i][y], i, y);
                        return gogo(count, whx, why, status, find1, find2);
                    }else if(map[i][y]>0){
                        return gogo(count+1, i, y, 2, 2, 3);
                    }
                }
        }
        return count;
    }

    static public void findwh(int find, int r, int c){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j] == find && !(i==r && j==c) ){
                    whx = i;
                    why = j;
                }
            }
        }
    }
}
