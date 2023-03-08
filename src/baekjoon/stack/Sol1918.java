package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol1918 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c: carr){
            if(c == '('){
                stack.push(c);
            } else if(c == ')'){
                while(stack.peek()!='('){
                    sb.append(stack.pop());
                }
                stack.pop();
            } else if(c == '*' || c == '/'){
                if(stack.isEmpty()) {
                    stack.push(c);
                }else if(stack.peek() == '*' || stack.peek() == '/' ){
                    sb.append(stack.pop());
                    stack.push(c);
                } else {
                    stack.push(c);
                }
            } else if( c=='+' || c=='-'){
                if(stack.empty()){
                    stack.push(c);
                } else{
                    while(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/'){
                        sb.append(stack.pop());
                        if(stack.size()==0) break;
                    }
                    stack.push(c);
                }
            } else{
                sb.append(c);
            }
        }

        while(stack.size()>0){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
