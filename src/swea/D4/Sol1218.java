package D4;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Sol1218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> cs1 = new Stack<Character>(); // ()
        Stack<Character> cs2 = new Stack<Character>(); // []
        Stack<Character> cs3 = new Stack<Character>(); // {}
        Stack<Character> cs4 = new Stack<Character>(); // <>
        for(int tc=1; tc<=10; tc++){
            int N = sc.nextInt();
            String str = sc.next();

            char[] carr = str.toCharArray();

            for(char c:carr){
                try{
                    switch (c) {
                        case '(':
                            cs1.push(c);
                            break;
                        case ')':
                            cs1.pop();
                            break;
                        case '[':
                            cs2.push(c);
                            break;
                        case ']':
                            cs2.pop();
                            break;
                        case '{':
                            cs3.push(c);
                            break;
                        case '}':
                            cs3.pop();
                            break;
                        case '<':
                            cs4.push(c);
                            break;
                        case '>':
                            cs4.pop();
                            break;
                    }
                } catch(EmptyStackException e){
                    System.out.printf("#%d %d\n",tc,0);
                    break;
                }
            }

            if(cs1.size()==0 && cs2.size()==0 && cs3.size()==0 && cs4.size()==0 ) {
                System.out.printf("#%d %d\n",tc,1);
            }

            cs1.clear();
            cs2.clear();
            cs3.clear();
            cs4.clear();

        }

    }
}
