import java.util.Scanner;

public class Sol1959 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N, M, max, sum;
        int[] arrn, arrm;

        for (int i = 1; i <= T; i++) {
            N = sc.nextInt();
            M = sc.nextInt();

            arrn = new int[N];
            arrm = new int[M];
            for(int j=0; j<N; j++) {
                arrn[j] = sc.nextInt();
            }
            for(int j=0; j<M; j++) {
                arrm[j] = sc.nextInt();
            }

            if (N > M) {
                int[] temp = arrn;
                arrn = arrm;
                arrm = temp;
            }
            max = Integer.MIN_VALUE;
            for(int j=0; j<(arrm.length - arrn.length + 1); j++) {
                int smidx = 0;
                sum = 0;
                for(int k=j; k<j+arrn.length; k++) {
                    sum += (arrn[smidx] * arrm[k]);
                    smidx++;
                }
                if (max < sum) max = sum;
            }

            System.out.printf("#%d %d\n", i, max);
        }
    }
}
