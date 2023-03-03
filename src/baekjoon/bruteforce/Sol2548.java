package bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Sol2548 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int sum=0;
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            sum=0;
            for(int j=0; j<N; j++){
                sum += Math.abs(arr[i]-arr[j]);
            }
            result[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int minidx = 0;
        for (int i = 0; i < N; i++) {
            if(result[i]<min){
                min=result[i];
                minidx=i;
            }
        }
        System.out.println(arr[minidx]);
    }
}
