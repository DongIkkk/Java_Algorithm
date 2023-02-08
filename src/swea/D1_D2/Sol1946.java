package D1_D2;

import java.util.Arrays;
import java.util.Scanner;

// 간단한 압축 풀기
public class Sol1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();


        for (int tc = 1; tc <= N; tc++) {
            int t = sc.nextInt();
            String[] ci = new String[t];
            int[] ki = new int[t];

            // 입력부, 전체를 담을 배열 길이 sum
            int sum=0;
            for (int i = 0; i < t; i++) {
                ci[i] = sc.next();
                ki[i] = sc.nextInt();
                sum += ki[i];
            }

            // 하나의 배열에 전체 담기
            String[] all = new String[sum];
            int index = 0;
            for(int i=0; i<t; i++){
                int k = ki[i];
                for(int j=0; j<k; j++){
                    all[index++] = ci[i];
                }
            }

            // 출력
            System.out.println("#"+tc);
            int count = 0;
            for(String s: all){
                count++;
                System.out.print(s);
                if(count==10){
                    System.out.println();
                    count=0;
                }
            }
            System.out.println();

        }



    }
}
