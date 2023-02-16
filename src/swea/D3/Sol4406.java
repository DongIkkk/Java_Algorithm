package D3;

import java.util.Scanner;

public class Sol4406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int tc = 1; tc<=T; tc++) {
            String s = sc.next();
            s=s.replace("a", "");
            s=s.replace("i", "");
            s=s.replace("o", "");
            s=s.replace("u", "");
            s=s.replace("e", "");
            System.out.printf("#%d %s\n", tc, s);
        }
    }
}
