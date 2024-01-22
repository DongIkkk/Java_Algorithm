package stack;

import java.util.Scanner;

public class Sol9935 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String exp = sc.next();

        int expSize = exp.length();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            result.append(S.charAt(i));

            if(result.length() >= expSize) {
                boolean check = true;

                for (int j = 0; j < expSize; j++) {
                    if (result.charAt(result.length() - j - 1) != exp.charAt(expSize - j - 1)) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    result.setLength(result.length() - expSize);
                }
            }
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(result.toString());
        }
    }
}
