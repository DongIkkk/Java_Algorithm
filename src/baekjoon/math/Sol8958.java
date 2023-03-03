package math;

import java.util.Scanner;

public class Sol8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            String s = sc.next();
            char[] carr = s.toCharArray();

            int now=0;
            int score=0;
            for(int i=0; i<carr.length; i++){
                if(carr[i]=='O'){
                    now++;
                    score+=now;
                }else{
                    now = 0;
                    score += now;
                }
            }
            System.out.println(score);
        }
    }
}
