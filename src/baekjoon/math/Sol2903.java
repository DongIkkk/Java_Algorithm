package math;

import java.util.Scanner;

public class Sol2903 {
    public static void main(String[] args) {
        // 0 1  2  3   4   5    6
        // 1 4 16 64 256 1024 4096
        // 22 33 55 81 1717 3333
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 1;

        for(int i=1; i<=n; i++){
            result *= 2;
        }
        System.out.println((result+1)*(result+1));


    }
}
