package D4;

import java.util.Scanner;

public class Sol14555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String s = sc.next();
            String[] sarr = s.split("");
            int count=0;
            for(int i=0; i<sarr.length-1; i++) {
                if(sarr[i].equals("(") && sarr[i+1].equals("|")) count++;
                if(sarr[i].equals("|") && sarr[i+1].equals(")")) count++;
                if(sarr[i].equals("(") && sarr[i+1].equals(")")) count++;
            }
            System.out.printf("#%d %d\n",tc,count);
        }
    }
}
