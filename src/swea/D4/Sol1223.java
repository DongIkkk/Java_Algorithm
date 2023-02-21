package D4;

import java.util.Scanner;
import java.util.Stack;

public class Sol1223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++) {
            int num = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();

            //후위표기법으로 바꾸기
            String[] sarr = str.split("");
            Stack<String> stack = new Stack<>();
            String str2 = "";

            for (int i = 0; i < sarr.length; i++) {
                if (sarr[i].equals("+")) {
                    if (stack.empty()) {
                        stack.push(sarr[i]);
                    } else if (stack.peek().equals("*") || stack.peek().equals("+")) {
                        str2 += stack.pop();
                        i--;
                    } else {
                        stack.push(sarr[i]);
                    }
                } else if (sarr[i].equals("*")) {
                    stack.push(sarr[i]);
                } else {
                    str2 += sarr[i];
                }
            }
            while (!stack.empty()) {
                str2 += stack.pop();
            }

            // 바뀐 표기법 계산하기
            String[] sarr2 = str2.split("");
            Stack<String> stack2 = new Stack<>();
            int result = 0;
            int a, b;
            String temp;
            for (int i = 0; i < sarr2.length; i++) {
                if (sarr2[i].equals("*")) {
                    a = Integer.parseInt(stack2.pop());
                    b = Integer.parseInt(stack2.pop());
                    temp = String.valueOf((a * b));
                    stack2.push(temp);
                } else if (sarr2[i].equals("+")) {
                    a = Integer.parseInt(stack2.pop());
                    b = Integer.parseInt(stack2.pop());
                    temp = String.valueOf((a + b));
                    stack2.push(temp);
                } else {
                    stack2.push(sarr2[i]);
                }
            }
            result = Integer.parseInt(stack2.pop());
            System.out.printf("#%d %d\n",tc,result);
        }
    }
}
