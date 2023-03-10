package BinarySearch;

import java.util.Scanner;

public class Sol1654 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        long[] lan = new long[k];

        long max = Long.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lan[i] = sc.nextLong();
            if(max<lan[i]) max = lan[i];
        }
        long search = 0;
        long min = 1L;
        while(min<=max){
            search = (min+max) / 2L;
            long count = 0L;

            for(long nn: lan){
                if(search>0){
                    count += nn / search;
                }
            }


            if(count >= n){
                min = search + 1;
            }else{
                max = search - 1;
            }
        }

        System.out.println(max);




    }
}
