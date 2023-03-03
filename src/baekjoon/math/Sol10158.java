package math;

import java.util.Scanner;

public class Sol10158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        // 상 1 하 2
        // 우 3 좌 4
        int ud = 1;
        int rl = 3;

        while(t>0){
            if(ud == 1){
                if(q==h){
                    ud=2;
                    q--;
                } else {
                    q++;
                    if(q==h){
                        ud=2;
                    }
                }
            } else {
                if(q==0){
                    ud=1;
                    q++;
                }else{
                    q--;
                    if(q==0){
                        ud=1;
                    }
                }
            }

            if(rl == 3){
                if(p==w){
                    rl=4;
                    p--;
                } else{
                    p++;
                    if(p==w){
                        rl=4;
                    }
                }
            }else{
                if(p==0){
                    rl=3;
                    p++;
                }else{
                    p--;
                    if(p==0){
                        rl=3;
                    }
                }
            }
            t--;
        }

        System.out.println(p+" "+q);
    }
}
