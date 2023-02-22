package D3;

import java.util.Scanner;

public class Sol1493 {
    public static void main(String[] args) {
        int[][] map = new int[300][300];
        int count=1;
        for(int i=2; i<=300; i++){
            for(int j=1; j<=i-1; j++){
                map[j][i-j] = count++;
            }
        }
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int p = sc.nextInt();
            int q = sc.nextInt();
            int x=0, y=0;
            int check=0;
            outer:
            for(int i=1; i<300; i++) {
                for (int j = 1; j < 300; j++) {
                    if (map[i][j] == p) {
                        x+=i;
                        y+=j;
                        check++;
                    }
                    if (map[i][j] == q) {
                        x+=i;
                        y+=j;
                        check++;
                    }
                    if(check==2)break outer;
                }
            }

            System.out.printf("#%d %d\n",tc,map[x][y]);
        }


    }
}
