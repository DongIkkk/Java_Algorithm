package greedy;

import java.util.*;

public class Sol1339 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] al = new int[26];
        for (int i = 0; i < N; i++) {
            String S = sc.next();

            int weight = 1;
            for (int j = 1; j <= S.length(); j++) {
                char c = S.charAt(S.length()-j);
                al[c-65] += weight;
                weight *= 10;
            }
        }

        Arrays.sort(al);

        int val = 9;
        int result = 0;
        for (int i = 25; i >= 0; i--) {
            result += al[i] * val--;
        }
        System.out.println(result);

    }
}
