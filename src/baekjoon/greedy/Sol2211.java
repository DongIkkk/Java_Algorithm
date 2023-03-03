package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Sol2211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = arr[i]*(N-i);
        }
        Arrays.sort(result);
        System.out.println(result[N-1]);
    }
}
