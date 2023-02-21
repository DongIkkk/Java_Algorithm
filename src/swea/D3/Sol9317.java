package D3;

import java.util.Scanner;

public class Sol9317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            char[] carr = new char[N];
            char[] carr2 = new char[N];
            String str = sc.next();
            String str2 = sc.next();

            carr = str.toCharArray();
            carr2 = str2.toCharArray();
            int count =0;
            for(int i=0; i<N; i++){
                if(carr[i]!=carr2[i]) count++;
            }

            System.out.printf("#%d %d",tc,N-count);
        }
    }
}
