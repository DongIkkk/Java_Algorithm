package D3;

import java.util.Scanner;

public class Sol8821 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int[] count = new int[10];

            String s = sc.next();
            char[] carr = s.toCharArray();
            int n = -1;
            for(char c:carr) {
                n = c - '0';
                if(count[n]==0)count[n]++;
                else if(count[n]==1)count[n]--;
            }
            int sum=0;
            for(int nn:count) {
                sum+=nn;
            }
            System.out.printf("#%d %d\n", tc, sum);
        }
    }
}
