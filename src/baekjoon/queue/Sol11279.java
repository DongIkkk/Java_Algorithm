package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sol11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 다른방법
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if (temp == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.poll());
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            }
            else pq.add(temp);
        }
        System.out.println(sb.toString());
    }
}
