package implementation;

import java.util.Scanner;

//1. 현재 칸 청소
//
//2. 주변 4칸 탐색 - 청소할곳 없음
//    후진 - 후진이벽이면 끝
//
//3. 주변 4칸 탐색 - 청소할 곳 있음
//    반시계회전


public class Sol14503 {
    //0북 1동 2남 3서
    static int[] gox = {-1,0,1,0};
    static int[] goy = {0,1,0,-1};
    static int[] backx = {1,0,-1,0};
    static int[] backy = {0,-1,0,1};

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int rx = sc.nextInt();
        int ry = sc.nextInt();
        int d = sc.nextInt(); //0북 1동 2남 3서

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int resultCnt = 1;
        while(true){

            map[rx][ry] = 2;
            int temp = cleanCheck(rx, ry, d);

            if(temp == 4){
                rx = rx + backx[d];
                ry = ry + backy[d];
                if(map[rx][ry]==1) break;
            }else{
                d = temp;
                rx = rx + gox[d];
                ry = ry + goy[d];
                resultCnt++;
            }
//            System.out.printf("다음좌표 : ( %d , %d) , 방향 : %d\n", rx, ry, d);

        }
        System.out.println(resultCnt);


    }

    /*
    d 0
    3 2 1 0
    d 1
    0 3 2 1
    d 2
    1 0 3 2
    d 3
    2 1 0 3

     */

    static public int cleanCheck(int x, int y, int d){
        for (int i = 3; i >= 0; i--) {
            int idx = (i+d)%4;
            int nextx = x + gox[idx];
            int nexty = y + goy[idx];

            if(map[nextx][nexty]==0){
                return idx;
            }
        }
        return 4;
    }
}
