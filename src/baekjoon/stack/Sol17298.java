package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Sol17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = new int[N];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {arr[0], 0});
        int temp;
        for (int i = 1; i < N; i++) {
            temp = arr[i];

            if(!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] pop = stack.pop();
                result[pop[1]] = temp;
                i--;
            } else {
                stack.push(new int[] {temp, i});
            }
        }

        while(!stack.isEmpty()) {
            result[stack.pop()[1]] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int n: result) {
            sb.append(n);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
