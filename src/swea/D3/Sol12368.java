package D3;

import java.util.Scanner;

public class Sol12368 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int h1 = sc.nextInt();
            int h2 = sc.nextInt();
            int result = h1+h2;
            if(result>=24) result-=24;
            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
