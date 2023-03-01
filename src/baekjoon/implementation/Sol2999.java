package implementation;

import java.util.Scanner;

public class Sol2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int N = s.length();
        int R = 0;
        int C = 0;
        for(int i=1; i<= (int)Math.sqrt(N); i++){
            if(N%i == 0){
                R = i;
                C = N/i;
            }
        }
        char[] inputc = s.toCharArray();
        char[][] map = new char[R][C];
        int idx=0;


        for(int j=0; j<C; j++){
            for(int i=0; i<R; i++){
//                System.out.print(map[i][j]);
                map[i][j] = inputc[idx++];
            }

        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
//                map[i][j] = inputc[idx++];
                System.out.print(map[i][j]);
            }
        }

    }
}
