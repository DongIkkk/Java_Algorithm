package D3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sol5215 {
    static int N, L;
    static List<int[]> result;
    static int[][] wofy;
    static int sumPrice=0;
    static int sumKcal=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Tc = sc.nextInt();
        for (int tc = 1; tc <= Tc ; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();

            wofy = new int[N][2];
            for(int i=0; i<N; i++){
                wofy[i][0] = sc.nextInt();
                wofy[i][1] = sc.nextInt();
            }
            sumPrice=0;
            sumKcal=0;
            // 모든경우의 수 저장할 result list
            result = new ArrayList<>();

            combination(0,sumPrice, sumKcal);

            int max = -1;
            // 칼로리 조건 맞는것 중 가장큰거찾기
            for( int[] narr : result){
                if(narr[1] <= L){
                    if(narr[0]>max) max = narr[0];
                }
            }

            System.out.printf("#%d %d\n",tc,max);
        }

    }

    public static void combination(int idx, int sumPrice, int sumKcal){
        if(idx == N){
            result.add(new int[] {sumPrice, sumKcal});
            return;
        }

        sumPrice += wofy[idx][0];
        sumKcal += wofy[idx][1];

        // 이번 인덱스는 안더해줬다 -> 더해줬던거 취소
        int cancelP = sumPrice - wofy[idx][0];
        int cancelK = sumKcal - wofy[idx][1];

        // 이번에 더해준거 - 다음 거 할지 안할지
        combination(idx+1, sumPrice, sumKcal);
        // 이번에 안더해준거 - 다음 거 할지 안할지
        combination(idx+1, cancelP, cancelK);
    }
}

