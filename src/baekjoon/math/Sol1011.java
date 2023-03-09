package math;

import java.util.Scanner;

public class Sol1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            int distance = y - x;

            int count = (int)Math.sqrt(distance);

            // 숫자 바뀌는 지점
            if(count == Math.sqrt(distance)) {
                System.out.println(count * 2 - 1);
            }
            else if(distance <= count * count + count) {
                System.out.println(count * 2);
            }
            else {
                System.out.println(count * 2 + 1);
            }

        }
    }
}
