package queue;

import java.io.*;
import java.util.*;

public class Sol2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Balloon> dq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            dq.addLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        while (dq.size() > 1) {

            Balloon now = dq.poll();

            sb.append(now.idx).append(" ");

            if (now.value > 0) {
                for (int i = 0; i < now.value-1; i++) {
                    dq.addLast(dq.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(now.value); i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        Balloon now = dq.poll();

        sb.append(now.idx).append(" ");

        System.out.println(sb);
    }

    static class Balloon {
        int idx, value;

        Balloon(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
