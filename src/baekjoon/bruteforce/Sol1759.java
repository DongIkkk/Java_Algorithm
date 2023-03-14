package bruteforce;

import java.util.Arrays;
import java.util.Scanner;
// 파이썬 구현 정답처리
public class Sol1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();
        char[] carr = new char[C];

        for (int i = 0; i < C; i++) {
            carr[i] = sc.next().charAt(0);
        }
        
        Arrays.sort(carr);
        System.out.println(Arrays.toString(carr));
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<L; i++){
        // 파이썬으로했음


        }

    }
}
