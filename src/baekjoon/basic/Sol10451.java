package basic;

import java.io.*;
import java.util.*;

public class Sol10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N+1];
            Queue<Integer> q = new LinkedList<>();

            int result = 0;
            for (int i = 1; i <= N ; i++) {
                if(!visited[i]) {
                    result++;
                    int temp = i;
                    while(true) {
                        visited[temp] = true;
                        if(!visited[arr[temp]]){
                            temp = arr[temp];
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}
