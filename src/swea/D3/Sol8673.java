package D3;

import java.util.Scanner;

public class Sol8673 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();
            int[] arr = new int[(int)Math.pow(2, N)];
            for(int i=0; i<(int)Math.pow(2, N); i++) {
                arr[i] = sc.nextInt();
            }

            int sum = 0;
            for(int i=N; i>0; i--) {
                int[] arr2 = new int[(int)Math.pow(2, i-1)];
                int idx = 0;
                for(int j=0; j<=((int)Math.pow(2, i))-2; j+=2) {
                    sum += (Math.max(arr[j], arr[j+1]) - Math.min(arr[j], arr[j+1]));
                    arr2[idx++] = Math.max(arr[j], arr[j+1]);
                }
                int idx2=0;
                for(int num:arr2) {
                    arr[idx2++] = num;
                }
            }

            System.out.printf("#%d %d\n",tc,sum);
        }
    }
}
