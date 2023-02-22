package D3;

import java.util.Scanner;

public class Sol1234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int N = sc.nextInt();
            String s = sc.next();
            String[] sarr = {"00", "11","22","33","44","55","66","77","88","99"};
            int check=0;
            while(true) {
                check = s.length();
                for(String ss:sarr) {
                    s=s.replaceAll(ss, "");
                }
                if(check == s.length())break;
            }
            System.out.printf("#%d %s\n",tc,s);

        }
    }
}
