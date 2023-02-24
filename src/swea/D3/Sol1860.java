package D3;

import java.util.Scanner;

public class Sol1860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N, M, K;
            //N몇명? M초마다 K개
            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();
            int[] csm = new int[11112];
            for(int i=0; i<N; i++){
                csm[sc.nextInt()]++;
            }

            int many = 0;
            int possible=1;
            for(int i=0; i<11112; i++){
                if(i!=0 && i%M == 0) many += K;

                many -= csm[i];
                if(many<0) {
                    possible=0;
                    break;
                }
            }

            if(possible==0) System.out.printf("#%d Impossible\n",tc );
            else System.out.printf("#%d Possible\n",tc );


        }

    }
}
