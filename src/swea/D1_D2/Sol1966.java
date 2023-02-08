package D1_D2;

import java.util.Arrays;
import java.util.Scanner;

public class Sol1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int tc = 1 ; tc <= N; tc++) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int i=0; i<size; i++) {
                arr[i]=sc.nextInt();
            }

            Arrays.sort(arr);
            System.out.print("#"+tc+" ");
            for(int num:arr) {
                System.out.printf("%d ",num);
            }
            System.out.println();
        }
    }
}