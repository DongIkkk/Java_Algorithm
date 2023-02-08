package D1_D2;

import java.util.Scanner;

public class Sol2007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int tc = 1; tc <= N ; tc++) {
            String input = sc.next();
            String input2 = String.copyValueOf(input.toCharArray());
            int result = 0;
            for(int i=1; i<=10; i++){
                String spl = input.substring(0,i);
                String spl2 = input2.substring(i,2*i);
//                System.out.println(spl + " "+ spl2);
                if(spl.hashCode() == spl2.hashCode()){
                    result=i;
                    break;
                }
            }
            System.out.printf("#%d %d\n",tc,result);
        }
    }
}
