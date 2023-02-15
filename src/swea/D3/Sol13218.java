package D3;

import java.util.Scanner;

public class Sol13218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int num = sc.nextInt();

            System.out.printf("#%d %d\n", tc, num/3);
        }
    }
}
