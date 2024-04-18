package MapSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol11507 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();

        Set<Integer> P = new HashSet<>();
        Set<Integer> K = new HashSet<>();
        Set<Integer> H = new HashSet<>();
        Set<Integer> T = new HashSet<>();

        for (int i = 0; i < S.length() / 3; i++) {
            int temp = Integer.parseInt(S.substring(3 * i + 1, 3 * i + 3));

            switch (S.charAt(i*3)) {
                case 'P':
                    if(P.contains(temp)) {
                        System.out.println("GRESKA");
                        return;
                    }
                    P.add(temp);
                    break;
                case 'K':
                    if(K.contains(temp)) {
                        System.out.println("GRESKA");
                        return;
                    }
                    K.add(temp);
                    break;
                case 'H':
                    if(H.contains(temp)) {
                        System.out.println("GRESKA");
                        return;
                    }
                    H.add(temp);
                    break;
                case 'T':
                    if(T.contains(temp)) {
                        System.out.println("GRESKA");
                        return;
                    }
                    T.add(temp);
                    break;
            }
        }

        System.out.printf("%d %d %d %d", 13-P.size(), 13-K.size(), 13-H.size(), 13-T.size());

    }
}
