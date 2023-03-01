package bruteforce;

import java.util.Scanner;

public class Sol2851 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int sum=0;
        int in=0;
        for(int i=0; i<10; i++){
            in = sc.nextInt();
            sum += in;
            arr[i] = sum;
        }
        int result = 10000;
        for(int n:arr){
            if(Math.abs(n-100) <= Math.abs(result - 100)) result = n;
        }
        System.out.println(result);
    }
}
