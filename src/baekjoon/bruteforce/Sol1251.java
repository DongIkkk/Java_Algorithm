package bruteforce;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sol1251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i = 1; i < S.length()-1; i++) {
            for (int j = i+1; j < S.length(); j++) {
                String str1 = new StringBuffer(S.substring(0, i)).reverse().toString();
                String str2 = new StringBuffer(S.substring(i, j)).reverse().toString();
                String str3 = new StringBuffer(S.substring(j, S.length())).reverse().toString();
                pq.add(str1+str2+str3);
            }
        }

        System.out.println(pq.poll());
    }
}
