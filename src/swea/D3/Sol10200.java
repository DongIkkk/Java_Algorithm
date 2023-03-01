package D3;

import java.util.Scanner;

public class Sol10200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int t = sc.nextInt();
            System.out.printf("#%d %d %d\n", tc, Math.min(p, t), (p+t-n >= 0) ? p+t-n : 0 );
        }
    }
}
