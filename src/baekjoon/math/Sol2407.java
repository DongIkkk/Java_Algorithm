package math;

import java.math.BigInteger;
import java.util.Scanner;

public class Sol2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger result = BigInteger.ONE;

        for (int i = n; i > n-m; i--) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        for (int i = m; i >= 1; i--) {
            result = result.divide(new BigInteger(String.valueOf(i)));
        }

        System.out.println(result);

    }
}
