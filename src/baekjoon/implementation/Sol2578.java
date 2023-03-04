package implementation;

import java.util.Scanner;

public class Sol2578 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] bingo = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        for(int i = 1; i<=25; i++){
            int num = sc.nextInt();

            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if(bingo[r][c] == num) bingo[r][c] = 0;
                }
            }
            int bgcnt = 0;
            for (int r = 0; r < 5; r++) {
                if(bingo[r][0]+bingo[r][1]+bingo[r][2]+bingo[r][3]+bingo[r][4]==0) bgcnt++;
                if(bingo[0][r]+bingo[1][r]+bingo[2][r]+bingo[3][r]+bingo[4][r]==0) bgcnt++;
            }
            if(bingo[0][0]+bingo[1][1]+bingo[2][2]+bingo[3][3]+bingo[4][4]==0) bgcnt++;
            if(bingo[0][4]+bingo[1][3]+bingo[2][2]+bingo[3][1]+bingo[4][0]==0) bgcnt++;

            if(bgcnt >= 3){
                System.out.println(i);
                break;
            }
        }
    }
}
