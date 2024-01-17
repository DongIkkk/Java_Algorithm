package basic;

import java.util.Scanner;

public class Sol3135 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int N = sc.nextInt();
        int[] arr = new int[N];

        int min = 999999;
        for (int i = 0; i < N; i++) {
            arr[i] = Math.abs(b - sc.nextInt());
            if( arr[i] < min) min = arr[i];
        }

        int nojump = Math.abs(a-b);

        boolean check = true;
        for(int nn : arr ) {
            if(nojump > nn) {
                check = false;
            }
        }

        if(check) {
            System.out.println(nojump);
            return;
        }

        System.out.println(min+1);

    }
}