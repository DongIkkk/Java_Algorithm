package D3;

import java.util.Scanner;

public class Sol10570 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int count = 0;

            for (int i = a; i <= b; i++) {
                if (ispalindrome(i)) {
                    if (Math.sqrt(i) % 1 == 0.0) {
                        if (ispalindrome((int) Math.sqrt(i))) count++;
                    }

                }
            }
            System.out.printf("#%d %d\n", tc, count);
        }
    }

    public static boolean ispalindrome(int x) {
        String s;
        s = String.valueOf(x);
        String[] sarr = s.split("");
        boolean b = true;
        for (int i = 0; i < sarr.length / 2; i++) {
            if (!sarr[0 + i].equals(sarr[sarr.length - 1 - i])) {
                b = false;
            }
        }
        return b;
    }
}
