package D4;

import java.util.Arrays;
import java.util.Scanner;

public class Sol7333 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[N];

            for(int i=0; i<N; i++) {
                arr[i]= sc.nextInt();
            }

            Arrays.sort(arr);
            int count = 0;
            int del = 0;
            for(int i=arr.length-1; i>=del; i--) {
                // 혼자남은경우
                if(i==del) {
                    count++;
                    break;
                }

                del += (int)(50 / arr[i]);
                if(arr[i]==50||arr[i]==25||arr[i]==10||arr[i]==5||arr[i]==2||arr[i]==1) del--;

                // 내가 혼자 빠졌을 때 남은 애들로 50이안되면
                if(arr[i-1] * (i-del) < 50) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }

            System.out.printf("#%d %d\n",tc,count);


        }

    }
}
