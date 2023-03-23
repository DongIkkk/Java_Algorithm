package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol6603 {
    static int n;
    static int[] narr;
    static List<String> results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            n = sc.nextInt();
            if(n==0) break;
            narr = new int[n];
            for (int i = 0; i < n; i++) {
                narr[i] = sc.nextInt();
            }

            results = new ArrayList<>();
            comb(0, 0,  "");

            for(String s : results){
                System.out.println(s);
            }
            System.out.println();
        }


    }

    public static void comb(int idx, int count, String s){
        if(count == 6) {
            results.add(s);
            return;
        } else if(idx==n){
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(String.valueOf(narr[idx]));
        sb.append(" ");
        comb(idx+1, count+1, sb.toString());
        comb(idx+1, count, s);

    }
}
