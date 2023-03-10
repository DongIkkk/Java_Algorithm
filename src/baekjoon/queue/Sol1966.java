package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] priority = new int[10];
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Queue<int[]> q = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                int pri = sc.nextInt();
                q.add(new int[] {j, pri});
                priority[pri]++;
            }
            int[] zzzz = new int[N];
            int idx=0;
            for(int j=9; j>=1; j--){
                if(priority[j]>0){
                    while(priority[j]!=0){
                        zzzz[idx++] = j;
                        priority[j]--;
                    }
                }
            }
            int count=0;
            outer:
            for(int nnn:zzzz){
                while(true){
                    int[] thiss = q.poll();
                    int x = thiss[0];
                    int y = thiss[1];
                    if(y == nnn && x == M){
                        System.out.println(++count);
                        break outer;
                    } else if(y==nnn){
                        count++;
                        break;
                    } else{
                        q.add(new int[] {x, y});
                    }
                }
            }

        }
    }
}
