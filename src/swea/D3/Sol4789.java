package D3;

import java.util.Scanner;

public class Sol4789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String in = sc.next();

            String[] sarr = in.split("");

            int clap = 0;
            int need = 0;
            int idx=0;
            while(idx<sarr.length-1) {
                clap += Integer.parseInt(sarr[idx++]);
                if(idx>clap) {
                    need += idx-clap;
                    clap += idx-clap;
                }
            }

            System.out.printf("#%d %d\n", tc, need);

        }
    }
}
