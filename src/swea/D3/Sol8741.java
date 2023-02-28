package D3;

import java.util.Scanner;

public class Sol8741 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            String s;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                s = sc.next();
                s = s.toUpperCase();
                sb.append(s.charAt(0));
            }
            System.out.printf("#%d %s\n", tc, sb);
        }
    }
}
