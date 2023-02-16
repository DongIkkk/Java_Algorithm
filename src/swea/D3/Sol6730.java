package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol6730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] minus = new int[N-1];
            for(int i=0; i<N-1; i++) {
                minus[i] = arr[i] - arr[i+1];
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int num:minus) {
                if(min>num) min = num;
                if(max<num) max = num;
            }
            if(min>=0 && max>=0) min = 0;
            if(min<0 && max<0) max = 0;
            min = Math.abs(min);
            max = Math.abs(max);
            System.out.printf("#%d %d %d\n",tc,min,max);

        }

    }
}
