package D1_D2;

import java.util.Scanner;

public class Sol1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int tc = sc.nextInt();
            System.out.printf("#%d ", tc);

            int[] arr = new int[101];
            for (int i=0; i<1000; i++){
                int score = sc.nextInt();
                arr[score]++;
            }
            int max = 0;
            int max_index = 0;
            for(int i=0; i<101; i++){
                if(arr[i]>=max){
                    max = arr[i];
                    max_index = i;
                }
            }
            System.out.printf("%d\n", max_index);
        }
    }
}
