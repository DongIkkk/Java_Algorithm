package implementation;

import java.util.Scanner;

// silver4 1244 스위치 켜고 끄기
public class Sol1244 {
    public static void main(String[] args) {
        // 남학생 - 자기가 받은 수의 배수이면 바꿈
        // 여학생 - 자신 포함 기준으로 양쪽 대칭이 유지되는 곳 까지 바꿈

        // ***** 0번 스위치 만들어준거 신경안썼음 *****
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] swc = new int[N+1];

        for (int i = 1; i <= N; i++) {
            swc[i] = sc.nextInt();
        }

        int students = sc.nextInt();
        for (int i = 0; i < students; i++) {
            int gen = sc.nextInt();
            int num = sc.nextInt();

            if (gen == 1) {
                for (int j = 1; j <= N; j++) {
                    if (j % num == 0) {
                        if (swc[j] == 0) swc[j] = 1;
                        else swc[j] = 0;
                    }
                }
            } else {
                if (swc[num] == 0) swc[num] = 1;
                else swc[num] = 0;

                int left = num;
                int right = num;
                while (true) {
                    left--;
                    right++;
                    if (left < 1 || right > N) break;

                    if (swc[left] == swc[right]) {
                        if (swc[left] == 0) swc[left] = 1;
                        else swc[left] = 0;

                        if (swc[right] == 0) swc[right] = 1;
                        else swc[right] = 0;
                    } else {
                        break;
                    }

                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ", swc[i]);
            if(i%20==0) System.out.println();
        }

    }
}
