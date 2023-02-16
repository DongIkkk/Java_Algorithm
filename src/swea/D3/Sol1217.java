package D3;

import java.util.Scanner;

public class Sol1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            int cnt=1;
            int result = rec(N, M, cnt, 1);

            System.out.printf("#%d %d\n",T, result);

        }
    }

    public static int rec(int n, int m, int cnt, int result) {
        if (cnt==m) return result*n;
        cnt++;
        result = result*n;
        return rec(n, m, cnt, result);
    }
}
