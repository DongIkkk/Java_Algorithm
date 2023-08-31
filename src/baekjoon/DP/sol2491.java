package DP;

import java.util.Scanner;

public class sol2491 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 1;
        int result = 1;

        for (int i = 0; i < n-1; i++) {
            if(arr[i]<=arr[i+1]) count++;
            else count = 1;
            result = Math.max(result, count);
        }
        count = 1;
        for (int i = 0; i < n-1; i++) {
            if(arr[i]>=arr[i+1]) count++;
            else count = 1;
            result = Math.max(result, count);
        }

        System.out.println(result);

    }
}
