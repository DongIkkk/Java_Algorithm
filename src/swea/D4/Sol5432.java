package D4;

import java.util.Scanner;

public class Sol5432 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int tc=1; tc<=T; tc++) {
            String str = sc.nextLine();

            String[] sarr = str.split("");
            int count = 0;
            int sticks = 0;
            for(int i=0; i<sarr.length-1; i++) {
                if(sarr[i].equals("(")) {
                    if(sarr[i+1].equals("(")) {
                        count++;
                    } else {
                        sticks += count;
                    }
                }
                else {
                    if(sarr[i+1].equals(")")) {
                        sticks++;
                        count--;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, sticks);
        }
    }
}
