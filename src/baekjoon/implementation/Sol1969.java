package implementation;

import java.io.*;
import java.util.*;

public class Sol1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] dna = new char[N][M];
        for (int i = 0; i < N; i++) {
            String S = br.readLine();

            for (int j = 0; j < M; j++) {
                dna[i][j] = S.charAt(j);
            }
        }

        int resultSum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] ACGT = new int[4];
            for (int j = 0; j < N; j++) {
                if(dna[j][i] == 'A') ACGT[0]++;
                else if(dna[j][i] == 'C') ACGT[1]++;
                else if(dna[j][i] == 'G') ACGT[2]++;
                else if(dna[j][i] == 'T') ACGT[3]++;
            }

            int max = -1;
            int maxIndex = 0;
            for (int j = 0; j < 4; j++) {
                if(max < ACGT[j]) {
                    max = ACGT[j];
                    maxIndex = j;
                }
            }

            resultSum += N - ACGT[maxIndex];
            if(maxIndex == 0) sb.append("A");
            else if(maxIndex == 1) sb.append("C");
            else if(maxIndex == 2) sb.append("G");
            else sb.append("T");
        }

        System.out.println(sb.toString());
        System.out.print(resultSum);
    }
}
