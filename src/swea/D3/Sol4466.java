package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Sol4466 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++) {
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int sum = 0;
            for(int i=N-1; i>= N-k; i--) {
                sum+= arr[i];
            }
            System.out.printf("#%d %d\n",tc,sum);
        }
    }
}
