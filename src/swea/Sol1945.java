import java.util.Scanner;

public class Sol1945 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();

            System.out.printf("#%d ", i + 1);

            int[] div = { 2, 3, 5, 7, 11 };

            for (int n : div) {
                int cnt = 0;
                while (num % n == 0) {
                    num = num/n;
                    cnt++;
                }
                System.out.printf("%d ", cnt);
            }

            System.out.println();

        }
    }
}
