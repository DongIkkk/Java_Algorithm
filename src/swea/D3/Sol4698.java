package D3;

import java.util.Scanner;

public class Sol4698 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] prime = new int[1000001];
        for(int i=2; i<1000001; i++) {
            if(prime[i]==1) continue;

            for(int j=i*2; j<1000001; j+=i) {
                prime[j] = 1;
            }
        }
        prime[1]=1;


        for(int tc=1; tc<=T; tc++) {
            int D, A, B;
            D = sc.nextInt();
            A = sc.nextInt();
            B = sc.nextInt();

            int count=0;

            for(int i=A; i<=B; i++) {
                if(prime[i]==0 && String.valueOf(i).contains(String.valueOf(D))) count++;
            }

            System.out.printf("#%d %d\n",tc,count);
        }
    }
}
