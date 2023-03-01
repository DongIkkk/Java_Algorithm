package D3;

import java.util.Scanner;

public class Sol7532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            // s 365 e 24 m 29

            int s,e,m;
            s=sc.nextInt();
            e=sc.nextInt();
            m=sc.nextInt();

            int dive=0;
            int divm=0;

            for(int i=s; i>=0; i+=365){
                if(i%24==0) dive = 24;
                else dive = i%24;

                if(i%29==0) divm = 29;
                else divm = i%29;

                if(dive == e && divm==m) {
                    System.out.printf("#%d %d\n",tc,i);
                    break;
                }
            }
        }

    }
}
