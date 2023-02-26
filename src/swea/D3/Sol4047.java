package D3;

import java.util.Scanner;

public class Sol4047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for( int tc=1; tc<=T; tc++) {
            String str = sc.next();
            int n = str.length()/3;
            String[] sarr = new String[n];
            for(int i=0; i<n; i++) {
                sarr[i] = str.substring(3*i, 3*i+3);
            }

            int[] spade = new int[14];
            int[] dia = new int[14];
            int[] heart = new int[14];
            int[] clober = new int[14];

            int num=0;
            int errcheck=0;
            for(String ss:sarr) {
                if(ss.charAt(0)=='S') {
                    num = Integer.parseInt(ss.substring(1, 3));
                    spade[num]++;
                    if(spade[num]==2) {
                        errcheck=1;
                        break;
                    }
                } else if(ss.charAt(0)=='D') {
                    num = Integer.parseInt(ss.substring(1, 3));
                    dia[num]++;
                    if(dia[num]==2) {
                        errcheck=1;
                        break;
                    }
                } else if(ss.charAt(0)=='H') {
                    num = Integer.parseInt(ss.substring(1, 3));
                    heart[num]++;
                    if(heart[num]==2) {
                        errcheck=1;
                        break;
                    }
                } else if(ss.charAt(0)=='C') {
                    num = Integer.parseInt(ss.substring(1, 3));
                    clober[num]++;
                    if(clober[num]==2) {
                        errcheck=1;
                        break;
                    }
                }
            }

            int scnt=0, dcnt=0, hcnt=0, ccnt=0;
            for(int i=1; i<=13; i++) {
                if(spade[i]==0) scnt++;
                if(dia[i]==0) dcnt++;
                if(heart[i]==0) hcnt++;
                if(clober[i]==0) ccnt++;
            }

            if(errcheck==1) {
                System.out.printf("#%d ERROR\n",tc);
            } else {
                System.out.printf("#%d %d %d %d %d\n",tc,scnt,dcnt,hcnt,ccnt);
            }
        }
    }
}
