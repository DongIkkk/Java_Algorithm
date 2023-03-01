package D3;

import java.util.Scanner;

public class Sol11856 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String s = sc.next();
            char[] carr = s.toCharArray();

            char c1 = 0;
            char c2 = 0;

            int check1 = 0;
            int check2 = 0;

            for(char c: carr) {
                if(c1 == 0) {
                    c1 = c;
                    check1++;
                } else if(c1 == c) {
                    check1++;
                } else if(c2 == 0) {
                    c2 = c;
                    check2++;
                } else if(c2 == c) {
                    check2++;
                }
            }

            if(check1==2 && check2==2) {
                System.out.printf("#%d Yes\n",tc);
            } else {
                System.out.printf("#%d No\n",tc);
            }

        }
    }
}
