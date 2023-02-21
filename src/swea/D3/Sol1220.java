package D3;

import java.util.Scanner;

public class Sol1220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10 ; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int scheck=0;
            int count = 0;
            for(int i=0; i<N; i++){
                scheck = 0;
                for(int j=99; j>=0; j--){
                    if(scheck ==1){
                        if (map[j][i]==1){
                            count++;
                            scheck=0;
                        }
                    }

                    if(map[j][i]==2){
                        scheck=1;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc,count);
        }
    }
}
