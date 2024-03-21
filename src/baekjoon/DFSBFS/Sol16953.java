package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        Queue<long[]> q = new LinkedList<>();

        q.add(new long[] {A, 1});

        int result = Integer.MAX_VALUE;
        boolean check = false;

        while(!q.isEmpty()) {
            long[] temp = q.poll();

            if(temp[0] == B) {
                result = Math.min(result, (int) temp[1]);
                check = true;
                continue;
            }

            if(temp[0] * 2 <= 1000000000L) {
                q.add(new long[]{temp[0] * 2, temp[1] + 1});
            }
            if(temp[0]*10 + 1 <= 1000000000L) {
                q.add(new long[] {temp[0]*10 + 1, temp[1] + 1});
            }

        }

        if(check) System.out.println(result);
        else System.out.println(-1);
    }
}
