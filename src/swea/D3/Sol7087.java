package D3;

import java.util.Arrays;
import java.util.Scanner;

public class Sol7087 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = sc.nextInt();
            String[] sarr = new String[N];
            for(int i=0; i<N; i++){
                sarr[i] = sc.next();
            }
            char[] carr = new char[N];
            int idx=0;
            for(String s:sarr){
                carr[idx++] = s.charAt(0);
            }
            Arrays.sort(carr);
            int count=0;
            if(carr[0]=='A') {
                count++;
                for(int i=1; i<N; i++){
                    if(carr[i] == carr[i-1]) continue;
                    else if ((carr[i] - carr[i-1]) == 1) count++;
                    else{
                        break;
                    }
                }
            }


            System.out.printf("#%d %d\n",tc,count);
        }
    }
}
