package queue;

import java.util.*;
import java.io.*;

public class Sol1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqRight = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(!pqLeft.isEmpty() && pqLeft.peek() <= temp && !pqRight.isEmpty() && temp >= pqRight.peek()) {
                pqRight.add(temp);
            } else {
                pqLeft.add(temp);
            }

            if(pqLeft.size() - pqRight.size() >= 2) {
                pqRight.add(pqLeft.poll());
            }
            if(pqRight.size() - pqLeft.size() >= 1) {
                pqLeft.add(pqRight.poll());
            }

            sb.append(pqLeft.peek());
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
