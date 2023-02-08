package D1_D2;

import java.util.Scanner;

public class Sol1984 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int tc = 1; tc <= N ; tc++) {
            int[] arr = new int[10];
            for(int i =0; i<10; i++){
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int num: arr){
                sum += num;
                if(max < num) max = num;
                if(min > num) min = num;
            }
            sum -= max+min;
            double result = (double) sum / 8;
            String str = String.format("%.0f", result);
            System.out.println("#"+tc+" "+str);
        }
    }
}
