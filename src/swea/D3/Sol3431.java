package D3;

import java.util.Scanner;

public class Sol3431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int min = sc.nextInt();
            int max = sc.nextInt();
            int time = sc.nextInt();

            if(time<min){
                System.out.printf("#%d %d\n", tc, min-time);
            } else if(time<=max){
                System.out.printf("#%d %d\n", tc, 0);
            } else{
                System.out.printf("#%d %d\n", tc, -1);
            }
        }
    }

}
