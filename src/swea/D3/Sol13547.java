package D3;

import java.util.Scanner;

public class Sol13547 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            String s = sc.next();
            char[] carr = s.toCharArray();
            int count = 0;
            for(char c: carr){
                if(c=='x') count++;
            }

            System.out.printf("#%d %s\n",tc, (count>7) ? "NO" : "YES");
        }
    }
}
