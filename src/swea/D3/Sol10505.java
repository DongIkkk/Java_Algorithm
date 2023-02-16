package D3;

import java.util.Scanner;

public class Sol10505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            int sum = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            int count = 0;
            for (int n : arr) {
                if ((n * N) <= sum) count++;
            }
            System.out.printf("#%d %d", tc, count);
        }
    }
}