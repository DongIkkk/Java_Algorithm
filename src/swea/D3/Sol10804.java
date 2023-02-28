package D3;

import java.util.Scanner;

public class Sol10804 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for (int tc =1; tc <=T ; tc++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();

            for(int i=s.length()-1; i>=0; i--){
                if(s.charAt(i) == 'q'){
                    sb.append("p");
                } else if(s.charAt(i) == 'p'){
                    sb.append("q");
                } else if(s.charAt(i) == 'd'){
                    sb.append("b");
                } else if(s.charAt(i) == 'b'){
                    sb.append("d");
                }
            }

            System.out.printf("#%d %s\n",tc,sb);
        }
    }
}
