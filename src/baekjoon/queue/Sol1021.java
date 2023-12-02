package queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] question = new int[m];

        for (int i = 0; i < m; i++) {
            question[i] = sc.nextInt();
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        int  count = 0;


        for (int t:question) {
            if(n == 1){
                break;
            }
            int half = n/2;
            boolean check = false;
            for (int i = 0; i < n; i++) {
                if(q.get(i) == t) {
                    if( i <= half) {
                        check = true;
                    } else {
                        check = false;
                    }
                }
            }

            if(check) {
                while(q.get(0) != t) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            } else {
                while(q.get(0) != t){
                    q.addFirst(q.pollLast());
                    count++;
                }
            }

            q.poll();
            n = n-1;
        }
        System.out.println(count);
    }
}
