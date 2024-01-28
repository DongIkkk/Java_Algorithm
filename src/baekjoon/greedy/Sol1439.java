package greedy;

import java.util.Scanner;

public class Sol1439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char temp;
        int flag;
        int result = 0;
        if(s.charAt(0) == '1') {
            flag = 1;
            for (int i = 0; i < s.length(); i++) {
                temp = s.charAt(i);
                if(temp == '0') {
                    if(flag == 1) {
                        result++;
                        flag = 0;
                    }
                } else {
                    flag = 1;
                }
            }
        } else {
            flag = 0;
            for (int i = 0; i < s.length(); i++) {
                temp = s.charAt(i);
                if(temp == '1') {
                    if(flag == 0) {
                        result++;
                        flag = 1;
                    }
                } else {
                    flag = 0;
                }
            }
        }

        System.out.println(result);
    }
}
