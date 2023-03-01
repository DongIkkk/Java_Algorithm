package D3;

import java.util.Scanner;

public class Sol8500 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {

            int N = sc.nextInt();
            int[] arr = new int[N];
            int max=-1;
            int sum = 0;
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
                sum+= arr[i];
                if(max<arr[i]) max = arr[i];
            }
            System.out.printf("#%d %d\n",tc,N+sum+max);

        }
    }
}
