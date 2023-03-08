package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        char c;
        while(true){
            stack.clear();
            String s = sc.nextLine();
            if(s.equals(".")) break;

            for(int i=0; i<s.length(); i++){
                c = s.charAt(i);
                if(c=='(' || c=='[') stack.push(c);
                else if(c==')' || c==']'){
                    if(stack.isEmpty() || (stack.peek() == '(' && c==']' ) || (stack.peek() == '[' && c == ')')){
                        stack.push(c);
                        break;
                    }
                    stack.pop();

                }
            }

            if(!stack.isEmpty()) System.out.println("no");
            else System.out.println("yes");
        }
    }
}
