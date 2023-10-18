package math;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();

        int rx = (ax * by) + (bx * ay);
        int ry = ay * by;
        BigInteger tempx = BigInteger.valueOf((ax * by) + (bx * ay));
        BigInteger tempy = BigInteger.valueOf(ay * by);
        BigInteger gcd = tempx.gcd(tempy);

        int gcdd = gcd.intValue();

        rx = rx / gcdd;
        ry = ry / gcdd;

        System.out.printf("%d %d", rx, ry);
    }
}
