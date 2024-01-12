package MapSet;

import java.util.HashSet;
import java.util.Scanner;

public class Sol5568 {
    static int[] arr;
    static int K;
    static int N;
    static HashSet<String> set = new HashSet<>();
    static boolean[] visieted;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        visieted = new boolean[N];
        gogo(0, "");

        System.out.println(set.size());
    }

    public static void gogo(int count, String s) {
        if(count == K) {
            set.add(s);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visieted[i]){
                visieted[i] = true;
                int temp = arr[i];
                gogo(count + 1, s + String.valueOf(temp));
                visieted[i] = false;
            }

        }
    }
}
