package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for( int tc =1 ; tc<=10; tc++) {
            br.readLine();


            char[][] map = new char[100][100];

            for(int i = 0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i] = st.nextToken().toCharArray();
            }
            int result = 0;
            boolean check = false;
            outer:
            for(int i=100; i>=1; i--) {

                for(int x=0; x<100; x++) {
                    for(int j=0; j<=100-i ; j++) {

                        check = false;
                        for(int k=0; k<=(i-1)/2 ; k++) {
                            if(map[x][j+k] == map[x][j+i-k-1]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if(check) {
                            result=i;
                            break outer;
                        }
                    }
                }
            }


            check = false;
            outer:
            for(int i=100; i>=1; i--) {

                for(int x=0; x<100; x++) {
                    for(int j=0; j<=100-i ; j++) {

                        check = false;
                        for(int k=0; k<=(i-1)/2 ; k++) {
                            if(map[j+k][x] == map[j+i-k-1][x]) {
                                check = true;
                            } else {
                                check = false;
                                break;
                            }
                        }
                        if(check) {
                            System.out.printf("#%d %d\n",tc,Math.max(result, i));
                            break outer;
                        }
                    }
                }
            }


        }

    }
}
