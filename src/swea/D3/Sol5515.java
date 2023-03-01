package D3;

import java.util.Scanner;

public class Sol5515 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            int m = sc.nextInt();
            int d = sc.nextInt();

            // 월0 화1 수2 목3 금4 토5 일6
            //1월 1일 금요일, 윤년

            int[] year = {0,31,29,31,30,31,30,31,31,30,31,30,31};
            int sum=0;
            for(int i=1; i<=m-1; i++){
                sum+=year[i];
            }
            sum += d;

            int result = sum % 7;
            int[] resultarr = {3,4,5,6,0,1,2};

            System.out.printf("#%d %d\n", tc, resultarr[result]);



        }
    }
}
