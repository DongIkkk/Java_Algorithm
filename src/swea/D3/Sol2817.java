package D3;

import java.util.Scanner;

public class Sol2817 {
    static int N, K;
    static int[] numArray;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Tc = sc.nextInt();
        for (int tc = 1; tc <= Tc ; tc++) {
            N = sc.nextInt();
            K = sc.nextInt();

            numArray = new int[N];

            for (int i = 0; i < N; i++) {
                numArray[i] = sc.nextInt();
            }
            count = 0;
            부분수열의합(0, 0);
            System.out.printf("#%d %d\n",tc,count);
        }
    }

    public static void 부분수열의합(int idx, int sum){
        if(idx == N){
            if(sum == K) count++;
            return;
        }

        부분수열의합(idx+1, sum);
        부분수열의합(idx+1, sum+numArray[idx]);
    }

}
