package D3;

import java.util.Scanner;

public class Sol11315 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            int N = sc.nextInt();
            sc.nextLine();
            String[][] map = new String[N][N];
            for (int i = 0; i < N; i++) {
                String in = sc.nextLine();
                map[i] =  in.split("");
            }


            int isomok = 0;
            int iso = 0;
            for(int i=0; i<N; i++){
                if(isomok>=1) break;
                iso=0;
                for(int j=0; j<N; j++) {
                    if (map[i][j].equals("o")) iso++;
                    else iso = 0;

                    if (iso == 5) isomok = 1;
                }
            }
            for(int i=0; i<N; i++){
                if(isomok>=1) break;
                iso=0;
                for(int j=0; j<N; j++) {
                    if (map[j][i].equals("o")) iso++;
                    else iso = 0;

                    if (iso == 5) isomok = 1;
                }
            }

            for(int i=0; i<N; i++){
                if(isomok>=1) break;
                for(int j=0; j<N; j++) {
                    if(i<=N-5 && j<=N-5){
                        if (map[i][j].equals("o")){
                            if(map[i+1][j+1].equals("o")&&map[i+2][j+2].equals("o")&&map[i+3][j+3].equals("o")&&map[i+4][j+4].equals("o")) {
                                isomok = 1;
                            }
                        }
                    }

                    if(i<=N-5 && j>=4){
                        if (map[i][j].equals("o")){
                            if(map[i+1][j-1].equals("o")&&map[i+2][j-2].equals("o")&&map[i+3][j-3].equals("o")&&map[i+4][j-4].equals("o")) {
                                isomok = 1;
                            }
                        }
                    }
                }
            }

            if(isomok>=1) {
                System.out.printf("#%d YES\n", tc);
            }else{
                System.out.printf("#%d NO\n", tc);
            }
        }
    }
}
