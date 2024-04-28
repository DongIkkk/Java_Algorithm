package prefixSum;

import java.io.*;
import java.util.*;

public class Sol3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottoms = new int[H+1];
        int[] tops = new int[H+1];

        for (int i = 0; i < N / 2; i++) {
            bottoms[Integer.parseInt(br.readLine())]++;
            tops[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= H; i++) {
            bottoms[i] += bottoms[i-1];
            tops[i] += tops[i-1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            int temp = bottoms[H] - bottoms[i-1];
            int topsI = H - i + 1;
            temp += tops[H] - tops[topsI-1];
            if(temp < min) {
                min = temp;
                count = 1;
            } else if(temp == min) count++;
        }

        System.out.printf("%d %d", min, count);
    }
}
