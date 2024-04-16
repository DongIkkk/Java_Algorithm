package MapSet;

import java.util.*;

public class Sol11656 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> set = new TreeSet<>();

        String S = sc.next();

        for (int i = 0; i < S.length(); i++) {
            set.add(S.substring(i));
        }

        for(String s: set) {
            System.out.println(s);
        }
    }
}
