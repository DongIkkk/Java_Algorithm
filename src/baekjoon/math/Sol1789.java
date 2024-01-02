package math;

import java.util.Scanner;

public class Sol1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();

        int temp = 1;
        int sum = 0;
        int count = 0;
        while(sum <= S) {
            sum += temp;
            temp++;
            count++;
        }
        System.out.println(count-1);
    }
}
