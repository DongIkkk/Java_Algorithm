package implementation;

import java.util.Scanner;

public class Sol1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = new int[N+1];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int temp = arr[i];

            int tg = 0;
            for (int j = 1; j <= N; j++) {
                if(result[j] == 0) count++;

                if(count == temp+1) {
                    tg = j;
                    break;
                }
            }
            result[tg] = i;
            count = 0;
        }

        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ", result[i]);
        }
    }
}
