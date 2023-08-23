package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        int command = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());

            if(command == 1){
                int pushNum = Integer.parseInt(st.nextToken());
                stack.push(pushNum);
            } else if(command == 2){
                if(stack.size()==0){
                    sb.append(-1);
                    sb.append("\n");
                }
                else {
                    sb.append(stack.pop());
                    sb.append("\n");
                }
            } else if(command == 3){
                sb.append(stack.size());
                sb.append("\n");
            } else if(command == 4){
                if(stack.size() == 0){
                    sb.append(1);
                    sb.append("\n");
                } else {
                    sb.append(0);
                    sb.append("\n");
                }
            } else if(command == 5){
                if(stack.size()==0){
                    sb.append(-1);
                    sb.append("\n");
                }
                else {
                    sb.append(stack.peek());
                    sb.append("\n");
                }
            }


        }

        System.out.println(sb);

    }
}
