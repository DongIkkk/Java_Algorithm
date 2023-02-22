package D3;

import java.util.Scanner;

public class Sol8658 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =1; tc<=T; tc++) {
            int[] arr = new int[10];

            for(int i=0; i<10; i++) {
                arr[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int num : arr) {
                int sum = 0;
                String s = String.valueOf(num);
                for(int j=0; j<s.length(); j++) {
                    sum += s.charAt(j)-'0';
                }
                if(max<sum) max=sum;
                if(min>sum) min=sum;
            }
            System.out.printf("#%d %d %d\n", tc, max, min);
        }
    }
}
