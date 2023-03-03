package greedy;

import java.util.Scanner;

public class Sol2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int five = 0;
        int fivetemp = N / 5;
        int pf=0;
        for (int i = fivetemp; i >= 0 ; i--) {
            int aa = N;
            aa -= i * 5;
            if(aa%3 == 0){
                pf = 1;
                five = i;
                break;
            }
        }
        if(pf==0) {
            if(N%3!=0)System.out.println(-1);
            else System.out.println(N/3);
        }
        else System.out.println(five + (N-(five*5)) / 3);
    }
}
