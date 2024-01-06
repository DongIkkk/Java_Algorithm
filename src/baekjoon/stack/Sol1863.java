package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String bye = st.nextToken();
            int tall = Integer.parseInt(st.nextToken());

            if(tall == 0) {
                result += stack.size();
                stack = new Stack<>();
            } else if(stack.isEmpty()) {
                stack.push(tall);
            } else {
                if(stack.peek() > tall) {
                    while(!stack.isEmpty() && stack.peek()>=tall) {
                        if(stack.peek() == tall) {
                            result--;
                        }
                        result++;
                        stack.pop();
                    }
                    stack.push(tall);
                } else {
                    stack.push(tall);
                }
            }
        }
        result += stack.size();
        System.out.println(result);
    }
}
