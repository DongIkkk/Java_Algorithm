package bruteforce;

import java.util.Scanner;

public class Sol19532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();



        outer:
        for (int i = 0; i <= 999; i++) {
            for (int j = 0; j <= 999; j++) {
                if (((a * i) + (b * j)) == c && ((d * i) + (e * j)) == f) {
                    System.out.printf("%d %d\n", i, j);
                    break outer;
                }

                if (((a * (i)) + (b * (-j))) == c && ((d * (i)) + (e * (-j))) == f) {
                    System.out.printf("%d %d\n", i, -j);
                    break outer;
                }

                if (((a * (-i)) + (b * (-j))) == c && ((d * (-i)) + (e * (-j))) == f) {
                    System.out.printf("%d %d\n", -i, -j);
                    break outer;
                }

                if (((a * (-i)) + (b * (j))) == c && ((d * (-i)) + (e * (j))) == f) {
                    System.out.printf("%d %d\n", -i, j);
                    break outer;
                }
            }
        }


    }
}
