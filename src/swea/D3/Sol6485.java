package D3;

import java.util.Scanner;

public class Sol6485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++ ){
            int[] arr = new int[5001];
            int N = sc.nextInt();
            int a,b;
            for(int i=0; i<N; i++){
                a=sc.nextInt();
                b=sc.nextInt();
                for(int j=a; j<=b; j++){
                    arr[j]++;
                }
            }
            int P = sc.nextInt();
            int[] parr = new int[P];
            for(int i=0; i<P; i++){
                parr[i]=sc.nextInt();
            }

            System.out.printf("#%d ",tc);
            for(int num:parr){
                System.out.printf("%d ",arr[num]);
            }
            System.out.println();

        }
    }
}
