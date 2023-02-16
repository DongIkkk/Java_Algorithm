package D3;

import java.util.Scanner;

public class Sol11688 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int tc = 1; tc <= T; tc++) {
            String s = sc.nextLine();
            String[] sarr = s.split("");
            int a=1;
            int b=1;

            for(String str:sarr){
                if(str.equals("L")){
                    b=a+b;
                }else{
                    a=a+b;
                }
            }

            System.out.printf("#%d %d %d\n",tc,a,b);
        }
    }
}
