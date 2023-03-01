package D3;

import java.util.Scanner;

public class Sol7985 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =1; tc<=T; tc++) {
            int k= sc.nextInt();

            int[] tree = new int[(int)Math.pow(2, k)];

            for(int i=1; i< (int)Math.pow(2, k); i++ ) {
                tree[i] = sc.nextInt();
            }

            System.out.printf("#%d ",tc);
            for(int i=1; i<=k; i++) {
                for(int j=0; j<(int)Math.pow(2, i-1);j++ ) {
                    System.out.printf("%d ",tree[   (int)Math.pow(2, k-i)  +  j* (int)Math.pow(2, k-i+1)]);
                }
                System.out.println();
            }
        }

    }
}
