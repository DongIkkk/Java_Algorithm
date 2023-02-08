package D1_D2;

import java.util.Scanner;

public class Sol1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)      {
            String input = sc.next();
            String[] arr = input.split("");
            String check = "0";
            int count = 0;
            for (String s: arr) {
                if(check.hashCode() != s.hashCode()) {
                    count++;
                    check = s;
                }

            }
            System.out.println("#"+test_case+" "+count);
        }
    }
}
