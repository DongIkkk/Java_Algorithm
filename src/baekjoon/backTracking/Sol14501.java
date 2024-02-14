package backTracking;

import java.util.Scanner;

public class Sol14501 {
    static int[] arrT, arrP;
    static int N, result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arrT = new int[N+1];
        arrP = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arrT[i] = sc.nextInt();
            arrP[i] = sc.nextInt();
        }

        result = 0;

        gogo(1,0);

        System.out.println(result);
    }

    static public void gogo(int day, int money) {
        if(day >= N+1) {
            result = Math.max(result, money);
            return;
        }

        gogo(day+1, money);

        if(day+arrT[day] <= N+1){
            gogo(day + arrT[day], money + arrP[day]);
        }

    }
}
