package DP;

import java.util.Scanner;

public class Sol1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        int[] fibo = new int[42];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= 41; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();

            if(n == 0) {
                sb.append("1 0\n");
            } else if(n == 1) {
                sb.append("0 1\n");
            } else {
                sb.append(fibo[n-1]);
                sb.append(" ");
                sb.append(fibo[n]);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
