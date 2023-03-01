package greedy;

import java.util.Scanner;

public class Sol2810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();

        String[] sarr = s.split("");
        int count=0;
        for(String ss:sarr){
            if(ss.equals("S"))count++;
        }
        int ll = (N-count)/2;

        int result = ll+count+1;
        if(N>result) System.out.println(result);
        else System.out.println(N);

    }
}
