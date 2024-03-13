package prefixSum;

import java.util.*;
import java.io.*;

public class Sol2143 {
    static int T, n, m;
    static long temp, result;
    static long[] sumA,sumB;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        sumA = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sumA[i] = sumA[i-1] + Integer.parseInt(st.nextToken());;
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        sumB = new long[m+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            sumB[i] = sumB[i-1] + Integer.parseInt(st.nextToken());;
        }

        Map<Long, Integer> mapA= new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i ; j++) {
                temp = sumA[i] - sumA[j];
                mapA.put(temp, mapA.containsKey(temp) ? mapA.get(temp)+1 : 1);
            }
        }

        Map<Long, Integer> mapB= new HashMap<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i ; j++) {
                temp = sumB[i] - sumB[j];
                mapB.put(temp, mapB.containsKey(temp) ? mapB.get(temp)+1 : 1);
            }
        }

        result = 0;

        for(long l : mapA.keySet()) {
            if(mapB.containsKey((long)T - l)) {
                result += (long) mapA.get(l) * mapB.get(T-l);
            }
        }

        System.out.println(result);



    }
}
