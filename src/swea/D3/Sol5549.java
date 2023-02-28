package D3;

import java.util.Scanner;

public class Sol5549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <=T ; tc++) {
            String s = sc.next();
            char c = s.charAt(s.length()-1);

            if((c-'0') ==1){
                System.out.printf("#%d Odd\n",tc);
            } else {
                System.out.printf("#%d Even\n",tc);
            }
        }
    }
}
