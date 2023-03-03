package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Sol11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        int sumsum = 0;
        for(int n:arr){
            sum += n;
            sumsum += sum;
        }
        System.out.println(sumsum);
    }
}
