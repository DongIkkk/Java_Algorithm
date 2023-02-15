package D1_D2;

import java.util.Base64;
import java.util.Scanner;

public class Sol1928 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for(int tc = 1; tc<=T; tc++){
            String encode = sc.nextLine();
            String decode = new String(Base64.getDecoder().decode(encode));
            System.out.printf("#%d %s\n", tc, decode);
        }
    }
}
