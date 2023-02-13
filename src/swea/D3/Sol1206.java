package D3;

import java.util.Scanner;

public class Sol1206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc = 1; tc<=10; tc++) {
            int bd = sc.nextInt();
            int[] arr = new int[bd];
            for(int i=0; i<bd; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            int max = 0;
            for(int i=2; i<= bd-3; i++) {
                if(arr[i]> arr[i-2] && arr[i]> arr[i-1] && arr[i]> arr[i+1] && arr[i]> arr[i+2]) {
                    max = Math.max((Math.max(arr[i-2], arr[i-1])) , (Math.max(arr[i+1], arr[i+2])));
                    sum += (arr[i] - max);
                }
            }

            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
