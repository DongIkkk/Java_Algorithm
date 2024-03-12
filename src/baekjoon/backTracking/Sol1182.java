package backTracking;

import java.io.*;
import java.util.*;

public class Sol1182 {
    static int N, S, result;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        gogo(0,0);
        if(S == 0) result--;
        System.out.println(result);

    }

    private static void gogo(int index, int sum) {
        if(index >= N) {
            if(sum == S) {
                result++;
            }
            return;
        }

        gogo(index+1, sum);
        gogo(index+1, sum + arr[index]);

    }
}
