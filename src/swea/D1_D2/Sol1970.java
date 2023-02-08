package D1_D2;

import java.util.Scanner;

public class Sol1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int tc = 1; tc <= N ; tc++) {
            int in = sc.nextInt();
            int[] divmoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            System.out.println("#"+tc);
            for(int num: divmoney){
                System.out.print(in/num+" ");
                in = in%num;
            }
            System.out.println();
        }
    }
}
