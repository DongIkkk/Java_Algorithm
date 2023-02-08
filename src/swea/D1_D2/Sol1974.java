package D1_D2;

import java.util.Scanner;
public class Sol1974 {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();

            for (int i = 1; i <= T; i++) {
                int[][] sudoku = new int[9][9];
                int result = 1;

                for(int j=0; j<9; j++) {
                    for(int k=0; k<9; k++) {
                        sudoku[j][k] = sc.nextInt();
                    }
                }

                // 행
                for(int j=0; j<9; j++) {
                    int[] row = new int[9];
                    for(int k=0; k<9; k++) {
                        row[sudoku[j][k]-1]++;
                    }

                    for(int num: row) {
                        if(num==0) {
                            result=0;
                            break;
                        }
                    }
                }

                // 열
                for(int j=0; j<9; j++) {
                    int[] col = new int[9];
                    for(int k=0; k<9; k++) {
                        col[sudoku[k][j]-1]++;
                    }

                    for(int num: col) {
                        if(num==0) {
                            result=0;
                            break;
                        }
                    }
                }

                // 3x3
                for(int j=0; j<=6; j+=3) {
                    for(int k=0; k<=6; k+=3) {
                        int[] arrs = new int[9];
                        int r = j+3;
                        int c = k+3;

                        for(int a=j;a<r;a++) {
                            for(int b=k; b<c; b++) {
                                arrs[(sudoku[a][b]-1)]++;
                            }
                        }

                        for(int num: arrs) {
                            if(num==0) {
                                result=0;
                                break;
                            }
                        }
                    }
                }

                System.out.printf("#%d %d\n", i, result);
            }
        }
}
