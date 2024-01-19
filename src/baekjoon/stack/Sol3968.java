package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol3968 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();

            String s = sc.next();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if(!stack.isEmpty()) {
                    if(stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }

            if(stack.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
