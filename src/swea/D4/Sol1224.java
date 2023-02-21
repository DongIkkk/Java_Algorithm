package D4;

import java.util.Scanner;
import java.util.Stack;

public class Sol1224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int num = sc.nextInt();
            String str = sc.next();

            char[] carr = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            char[] trans = new char[num];
            int idx = 0;
            for (int i = 0; i < carr.length; i++) {
                if (carr[i] == '+' || carr[i] == '-') {
                    if (stack.empty()) {
                        stack.push(carr[i]);
                    } else if (stack.peek() == '(') {
                        stack.push(carr[i]);
                    } else {
                        trans[idx++]=stack.pop();
                        i--;
                    }
                } else if (carr[i]== '*' || carr[i]== '/') {
                    if(stack.empty()){
                        stack.push(carr[i]);
                    } else if (stack.peek() == '*' || stack.peek() == '/'){
                        trans[idx++]=stack.pop();
                        i--;
                    } else{
                        stack.push(carr[i]);
                    }
                } else if (carr[i] == '(') {
                    stack.push(carr[i]);
                } else if(carr[i] == ')'){
                    while(stack.peek() != '('){
                        trans[idx++] = stack.pop();
                    }
                    stack.pop();
                } else{
                    trans[idx++] = carr[i];
                }
            }
            while (!stack.empty()) {
                trans[idx++] += stack.pop();
            }

//             바뀐 표기법 계산하기
            Stack<Integer> stack2 = new Stack<>();
            int result = 0;
            int a, b;
            for (int i = 0; i < trans.length; i++) {
                if (Character.isDigit(trans[i])) {
                    stack2.push((int) trans[i]-'0');
                } else {
                    if (trans[i] == '+'){
                        a = stack2.pop();
                        b = stack2.pop();

                        stack2.push(a+b);
                    } else if(trans[i] == '-'){
                        a = stack2.pop();
                        b = stack2.pop();
                        stack2.push(a-b);
                    } else if(trans[i] == '*'){
                        a = stack2.pop();
                        b = stack2.pop();
                        stack2.push(a*b);
                    } else if(trans[i] == '/'){
                        a = stack2.pop();
                        b = stack2.pop();
                        stack2.push(a/b);
                    }
                }
            }
            result = stack2.pop();
            System.out.printf("#%d %d\n",tc,result);
        }
    }
}

