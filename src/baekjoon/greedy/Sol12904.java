package greedy;

import java.util.Scanner;

public class Sol12904 {
    static String S, T;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();

        gogo(T);
        System.out.print(result);
    }

    static public void gogo(String now) {
        if(now.equals(S)) result = 1;
        if(now.length() < S.length()) return;

        if(now.charAt(now.length()-1) == 'A') {
            gogo(now.substring(0, now.length()-1));
        } else {
            now = now.substring(0, now.length()-1);
            StringBuffer sb = new StringBuffer(now);
            gogo(sb.reverse().toString());
        }
    }
}
