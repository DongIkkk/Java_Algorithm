package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.util.Stack;

public class Sol17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] carr = s.toCharArray();

        boolean kkeok = false;

        Stack<Character> stack = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for(char c:carr){
            if(c=='<'){
                while(stack.size()!=0){
                    q.add(stack.pop());
                }
                kkeok = true;
                q.add(c);
                continue;
            }
            if(c=='>'){
                kkeok = false;
                q.add(c);
                continue;
            }

            if(c==' '){
                while(stack.size()!=0){
                    q.add(stack.pop());
                }
                q.add(c);
                continue;
            }

            if(kkeok){
                q.add(c);
                continue;
            }else{
                stack.push(c);
            }


        }
        while(stack.size()!=0){
            q.add(stack.pop());
        }
        while(q.size() != 0){
            System.out.print(q.poll());
        }
    }
}
