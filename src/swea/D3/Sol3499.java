package D3;

import java.util.Scanner;

public class Sol3499 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            String[] sarr = new String[N];
            for(int i=0; i<N; i++){
                sarr[i] = sc.next();
            }
            int half = N-(N/2);
            String[] a = new String[half];
            String[] b = new String[N/2];

            int bidx=0;
            for(int i=0; i<N; i++){
                if(i<half){
                    a[i]=sarr[i];
                }else{
                    b[bidx++]=sarr[i];
                }
            }

            System.out.printf("#%d ",tc);
            for(int i=0; i<half; i++){
                System.out.printf("%s ",a[i]);
                if(N%2==1 && i==half-1)break;
                System.out.printf("%s ",b[i]);
            }
            System.out.println();

        }
    }
}
