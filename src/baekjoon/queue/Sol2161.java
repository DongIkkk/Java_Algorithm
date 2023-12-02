package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while(!q.isEmpty()){
            System.out.printf("%d ", q.poll());
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
    }
}
