package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        Stack<Character> stack = new Stack<>();
        int result=0;
        boolean l = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push('(');
                l = false;
            } else {
                stack.pop();
                if(l) {
                    result+=1;
                } else {
                    result += stack.size();
                }
                l = true;
            }

        }
        System.out.println(result);
    }
}
