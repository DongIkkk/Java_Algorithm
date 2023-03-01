package D3;

import java.util.Scanner;

public class Sol14178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int result = 0;
            if(n%(1+2*d) == 0 ) result =n/(1+2*d);
            else result = n/(1+2*d) + 1;
            System.out.printf("#%d %d\n",tc,result);
        }
    }
}
