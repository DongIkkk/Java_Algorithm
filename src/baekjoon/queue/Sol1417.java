package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Sol1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int mine = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N-1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(true) {
            if(!pq.isEmpty() && pq.peek() >= mine) {
                pq.add(pq.poll() - 1);
                mine++;
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);

    }
}
