package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1231 {
    public static int N;
    public static char[] carr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc =1; tc<=10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            carr = new char[N+1];


            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                carr[num] = st.nextToken().charAt(0);
            }

            System.out.printf("#%d ",tc);
            LVR(1);
            System.out.println();


        }


    }

    public static void LVR(int x) {
        if(x<=N && carr[x] != 0) {
            LVR(x*2);
            System.out.printf("%c",carr[x]);
            LVR(x*2+1);
        }
    }


}
