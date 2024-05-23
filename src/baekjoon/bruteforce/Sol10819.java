package bruteforce;

import java.io.*;
import java.util.*;

public class Sol10819 {
    static int N, result;
    static int[] arr, temp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[N];
        temp = new int[N];

        dfs(0);

        System.out.print(result);
    }

    public static void dfs(int count) {
        if(count == N) {
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[count] = arr[i];
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
}
