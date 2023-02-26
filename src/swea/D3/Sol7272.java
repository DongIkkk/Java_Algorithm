package D3;

import java.util.Scanner;

public class Sol7272 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            String s1 = sc.next();
            String s2 = sc.next();

            String[] sr1 = s1.split("");
            String[] sr2 = s2.split("");

            if(sr1.length != sr2.length) {
                System.out.printf("#%d DIFF\n",tc);
                continue;
            }
            int x, y;
            boolean check = true;
            for(int i=0; i<sr1.length; i++) {
                switch (sr1[i]) {
                    case "B":
                        x=2;
                        break;
                    case "A": case "D": case "O": case "P": case "Q": case "R":
                        x=1;
                        break;
                    default:
                        x=0;
                        break;
                }

                switch (sr2[i]) {
                    case "B":
                        y=2;
                        break;
                    case "A": case "D": case "O": case "P": case "Q": case "R":
                        y=1;
                        break;
                    default:
                        y=0;
                        break;
                }

                if(x != y) {
                    System.out.printf("#%d DIFF\n",tc);
                    check = false;
                    break;
                }
            }
            if(check) {
                System.out.printf("#%d SAME\n",tc);
            }

        }

    }
}
