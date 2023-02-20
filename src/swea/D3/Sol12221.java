package D3;

import java.util.Scanner;

public class Sol12221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a>=10 || b>=10){
                System.out.printf("#%d %d\n",tc,-1);
            }else{
                System.out.printf("#%d %d\n",tc,a*b);
            }
        }
    }
}
