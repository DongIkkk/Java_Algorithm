package D3;

import java.util.Scanner;

public class Sol7964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            int D = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            int result=0;
            for(int i=0; i<N-D+1; i++){
                int count=0;
                for(int j=0; j<D; j++){
                    if(arr[i+j]==0) count++;
                }
                if(count==D) {
                    arr[i+D-1]=1;
                    result++;
                }
            }

            System.out.printf("#%d %d\n", tc, result);

        }
    }
}
