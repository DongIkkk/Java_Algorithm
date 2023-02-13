package basic;

import java.util.Scanner;

// 브2 구현 영식이와 친구들
public class Sol1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, L;
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();

        if(L>=N) L = L%N;

        int[] table = new int[N+1];
        int count = 0;
        int next = 1;
        while(true){
            table[next]++;
            if(table[next] == M) break;
            count++;

            if(table[next]%2 == 1){
                next = next + L;
                if(next>N) next=next-N;
            } else{
                next = next - L;
                if(next<=0) next = next+N;
            }
        }
        System.out.println(count);
    }
}
