package basic;

import java.util.Scanner;

public class Sol3231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] check = new int[n+2];

        int result = 0;
        int temp = 0;

        // 나보다 1작은애가 내뒤에오면 count
        for (int i = 0; i < n; i++) {
            temp = sc.nextInt();
            if(check[temp+1]>0) result++;
            check[temp] = 1;
        }
        System.out.println(result);
    }
}