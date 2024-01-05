package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 1;
        int rear = 1;
        int sum = 0;
        int result = 0;

        while(true) {
            if(sum >= M) {
                sum -= arr[front];
                front++;
            } else if (rear == N+1){
                break;
            } else {
                sum += arr[rear];
                rear++;
            }

            if(sum == M) {
                result++;
            }
        }

        System.out.println(result);

    }
}
