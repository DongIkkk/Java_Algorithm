package D1_D2;

import java.util.Scanner;

public class Sol1284 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int tc = 1 ; tc <= N; tc++) {
            int P, Q, R, S, W;
            P = sc.nextInt();
            Q = sc.nextInt();
            R = sc.nextInt();
            S = sc.nextInt();
            W = sc.nextInt();

            int a = P * W;
            int b = 0;
            if(R >= W) b=Q;
            else {
                b = Q + (W-R)*S;
            }

            System.out.printf("#%d %d\n", tc, Math.min(a, b));

        }

    }
}