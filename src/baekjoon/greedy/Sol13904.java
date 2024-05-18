package greedy;

import java.io.*;
import java.util.*;

public class Sol13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o2[1] - o1[1]
        );

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int result = 0;

        boolean[] check = new boolean[1001];    // 해당일에 과제를 했는지

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if(!check[temp[0]]) {
                result += temp[1];
                check[temp[0]] = true;
            } else {
                for (int i = temp[0] - 1; i >= 1 ; i--) {
                    if(!check[i]) {
                        result += temp[1];
                        check[i] = true;
                        break;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
