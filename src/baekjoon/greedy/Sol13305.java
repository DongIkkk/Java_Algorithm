package greedy;

import java.io.*;
import java.util.*;

public class Sol13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] dis = new int[N-1];
        int[] ppl = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ppl[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long tempppl = ppl[0];

        for (int i = 0; i < N-1; i++) {
            if(tempppl > ppl[i]) tempppl = ppl[i];

            sum += tempppl * dis[i];
        }
        System.out.println(sum);

    }
}
