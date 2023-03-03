package math;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol8320 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        Set<String> set = new HashSet<>();
//
//        for(int i=2; i<=n; i++) {
//            for (int j = 2; j <= n; j++) {
//                if (i * j <= n) {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(Math.min(i, j));
//                    sb.append(Math.max(i, j));
//                    String s = sb.toString();
//                    set.add(s);
//                }
//            }
//        }
//        System.out.println(set.toString());
//        System.out.println(set.size()+n);

        int cnt = 0;
        for(int i=1; i<n+1; i++)
            for(int j=1; j<=i; j++)
                if(i*j <= n)
                    cnt++;
        System.out.println(cnt);
    }
}
