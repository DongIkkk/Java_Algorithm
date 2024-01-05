package math;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int w = sc.nextInt();
            int e = sc.nextInt();
            BigInteger temp1 = BigInteger.ONE;
            for (int j = e; j >= 1 ; j--) {
                temp1 = temp1.multiply(BigInteger.valueOf(j));
            }

            BigInteger temp2 = BigInteger.ONE;
            for (int j = w; j >= 1 ; j--) {
                temp2 = temp2.multiply(BigInteger.valueOf(j));
            }

            BigInteger temp3 = BigInteger.ONE;
            for (int j = e-w; j >= 1 ; j--) {
                temp3 = temp3.multiply(BigInteger.valueOf(j));
            }

            System.out.println(temp1.divide(temp2.multiply(temp3)));
        }
    }
}
