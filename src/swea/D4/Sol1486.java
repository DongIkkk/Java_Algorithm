package D4;

import java.util.Scanner;

public class Sol1486 {
    static int n,b,result;
    static int[] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T ; tc++) {
            n = sc.nextInt();
            b = sc.nextInt();
            people = new int[n];
            for (int i = 0; i < n; i++) {
                people[i] = sc.nextInt();
            }

            result = Integer.MAX_VALUE;
            gogo(0,0);

            System.out.printf("#%d %d\n",tc,result-b);
        }
    }

    public static void gogo(int idx, int sum){
        if(idx == n){
            if(sum>=b && sum < result) result = sum;
            return;
        }

        gogo(idx+1, sum+people[idx]);
        gogo(idx+1, sum);
    }
}
