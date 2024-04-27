package greedy;

import java.io.*;
import java.util.*;

public class Sol11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] inputs = new int[N][2];
        for (int i = 0; i < N; i++) {
            inputs[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(inputs, (Comparator.comparingInt(x -> x[0])));

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));

        for (int i = 0; i < N; i++) {
            if(!pq.isEmpty() && pq.peek()[1] <= inputs[i][0]) {
                pq.poll();
            }
            pq.add(inputs[i]);
        }

        System.out.print(pq.size());
    }
}
