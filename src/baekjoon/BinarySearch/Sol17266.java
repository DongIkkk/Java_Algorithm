package BinarySearch;

import java.io.*;
import java.util.*;

public class Sol17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = Integer.parseInt(st.nextToken());
        int max = temp;
        for (int i = 0; i < M-1; i++) {
            int next = Integer.parseInt(st.nextToken());
            max = Math.max((next - temp) % 2 == 1 ? (next - temp) / 2 + 1 : (next - temp) / 2, max);
            temp = next;
        }
        max = Math.max((N - temp), max);
        System.out.print(max);
    }
}
