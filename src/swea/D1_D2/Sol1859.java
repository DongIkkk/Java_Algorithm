package D1_D2;

import java.util.Scanner;

public class Sol1859 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T ; tc++) {


            int N = sc.nextInt();

            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            long sum=0;
            int max=arr[N-1];

            for(int i=N-1; i>=0; i--) {
                if(arr[i]>=max) {
                    max=arr[i];
                } else {
                    sum += max-arr[i];
                }
            }

            System.out.printf("#%d %d\n", tc, sum);

        }

    }
}
