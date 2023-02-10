package basic;

import java.util.Scanner;

public class Sol2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A, B, C;
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        int mul = A * B * C;

        String str = String.valueOf(mul);
        String[] arr = str.split("");
        int[] numarr = new int[10];
        for (String s:arr){
            int n = Integer.parseInt(s);
            numarr[n]++;
        }
        for(int num : numarr){
            System.out.println(num);
        }
    }
}
