package D3;

import java.util.*;
import java.io.*;

public class Sol1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10 ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            char[][] carr = new char[8][8];

            for (int i = 0; i < 8 ; i++) {
                st = new StringTokenizer(br.readLine());
                carr[i] = st.nextToken().toCharArray();
            }

            int result = 0;

//            가로먼저
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8-N; j++) {
                    boolean check = true;
                    for(int k=0; k<N/2; k++){
                        if(carr[i][j+k] != carr[i][j+N-1-k]){
                            check = false;
                        }
                    }
                    if(check) result++;
                }
            }

            for (int i = 0; i <= 8-N; i++) {
                for (int j = 0; j < 8; j++) {
                    boolean check = true;
                    for(int k=0; k<N/2; k++){
                        if(carr[i+k][j] != carr[i+N-1-k][j]){
                            check = false;
                        }
                    }
                    if(check) result++;
                }
            }

            System.out.printf("#%d %d",tc,result);

        }


    }
}
