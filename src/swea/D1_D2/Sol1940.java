package D1_D2;

import java.util.Scanner;

public class Sol1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int N = sc.nextInt();

            int speednow = 0;
            int distance = 0;
            int speed = 0;


            for(int i=0; i<N; i++) {
                int type = sc.nextInt();
                if (type != 0) {
                    speed = sc.nextInt();
                }

                if(type ==0) {
                    distance += speednow;
                } else if(type == 1) {
                    speednow += speed;
                    distance += speednow;
                } else if(type == 2) {
                    speednow -= speed;
                    if(speednow<=0) speednow=0;
                    distance += speednow;
                }
            }

            System.out.printf("#%d %d\n", tc, distance);

        }

    }
}
