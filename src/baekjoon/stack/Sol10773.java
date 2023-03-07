package stack;

import java.util.Scanner;
import java.util.Stack;

public class Sol10773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            if(n==0) stack.pop();
            else stack.push(n);
        }
        int sum=0;
        while(stack.size()!=0){
            sum+=stack.pop();
        }
        System.out.println(sum);
    }
}
