package DP;

import java.util.Scanner;

public class Sol9095 {
    static int[] memo = new int[15];

    public static void main(String[] args) {
        memo[0] =1;
        memo[1] =1;
        memo[2] =2;

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++) {
            int N = sc.nextInt();
            System.out.println(zzz(N));
        }

    }

    public static int zzz(int n) {
        if(n<=2) return memo[n];
        else {
            memo[n] = zzz(n-3) + zzz(n-2) + zzz(n-1);
        }

        return memo[n];
    }
}
