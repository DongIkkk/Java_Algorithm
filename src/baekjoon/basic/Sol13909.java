package basic;

import java.util.Scanner;

public class Sol13909 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int sq = 1;
        while(true) {
            if(sq * sq <= n) {
                sq++;
            } else break;
        }
        System.out.println(sq-1);
    }
}
