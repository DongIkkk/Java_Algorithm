package implementation;

import java.io.*;
import java.util.*;

public class Sol1091 {
    static int N;
    static int[] P, S, now;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        now = new int[N];
        for (int i = 0; i < N; i++) now[i] = i;

        int count = 0;
        while (!isGood()) {
            shuffle();
            count++;
            if(isInf()) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(count);
    }

    public static void shuffle(){
        int[] temp = new int[N];

        for (int i = 0; i < N; i++) {
            temp[S[i]] = now[i];
        }

        for (int i = 0; i < N; i++) {
            now[i] = temp[i];
        }
    }

    public static boolean isGood(){
        for (int i = 0; i < N; i++) {
            if(P[now[i]] != i % 3) return false;
        }
        return true;
    }

    public static boolean isInf(){
        for (int i = 0; i < N; i++) {
            if(now[i] != i) return false;
        }
        return true;
    }
}
