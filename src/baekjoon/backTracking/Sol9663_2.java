package backTracking;

import java.util.Scanner;

public class Sol9663_2 {
    static int N, result;
    static boolean[] col, left, right;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        col = new boolean[N];
        left = new boolean[2 * N - 1];
        right = new boolean[2 * N - 1];

        result = 0;
        Queen(0);

        System.out.println(result);
    }

    private static void Queen(int depth) {
        if (depth == N) {
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!col[i] && !right[depth + i] && !left[N - 1 + depth - i]) {
                col[i] = true;
                right[depth + i] = true;
                left[N - 1 + depth - i] = true;

                Queen(depth + 1);

                col[i] = false;
                right[depth + i] = false;
                left[N - 1 + depth - i] = false;
            }
        }
    }
}
