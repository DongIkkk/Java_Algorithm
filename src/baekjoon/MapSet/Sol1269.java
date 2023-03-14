package MapSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sol1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int inNum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < a; i++) {
            inNum = sc.nextInt();
            set.add(inNum);
        }
        int resultA = set.size();
        for (int i = 0; i < b; i++) {
            inNum = sc.nextInt();
            set.add(inNum);
        }

        int resultB = set.size() - resultA;
        resultA = resultA - (b - resultB);

        System.out.println(resultA + resultB);
    }
}
