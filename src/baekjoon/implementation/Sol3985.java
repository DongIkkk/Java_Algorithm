package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Sol3985 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int N = sc.nextInt();

        int[] cake = new int[L+1];

        int expect = Integer.MIN_VALUE;
        int expectperson = 0;
        int real = Integer.MIN_VALUE;
        int realperson=0;
        for(int i=1; i<=N; i++){
            int p = sc.nextInt();
            int k = sc.nextInt();

            if(expect < k-p+1) {
                expect = k-p+1;
                expectperson = i;
            }

            int count =0;
            for(int j=p; j<=k; j++){
                if(cake[j]==0) {
                    cake[j]=i;
                    count++;
                }
            }
            if(real<count) {
                real=count;
                realperson=i;
            }
        }
        System.out.println(Arrays.toString(cake));
        System.out.println(expectperson);
        System.out.println(realperson);
    }
}
