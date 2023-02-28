package D3;

import java.util.Scanner;

public class Sol4751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String s = sc.next();
            char[] carr = s.toCharArray();

            String a = ".#..";
            String b = "#.#.";

            for(int i=0; i<5; i++) {
                if(i==2) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }

                for(int j=0; j<carr.length; j++) {
                    if(i==0 || i ==4) {
                        System.out.print(a);
                    } else if(i==1 || i==3) {
                        System.out.print(b);
                    } else {
                        System.out.print(".");
                        System.out.print(carr[j]);
                        System.out.print(".");
                        System.out.print("#");
                    }
                }
                System.out.println();
            }
        }

    }
}
