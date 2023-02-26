package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Sol1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();
        Queue<String> q = new LinkedList<>();
        int number = 1;
        int idx=0;
        while(true){
            if(s.empty()) {
                s.push(number++);
                q.add("+");
            }

            if(s.peek() == arr[idx]){
                s.pop();
                q.add("-");
                idx++;
                if(idx>N-1)break;
                if(arr[idx] < number){
                    if(s.peek()!= arr[idx]) {
                        System.out.println("NO");
                        return;
                    }
                }
            } else{
                s.push(number++);
                q.add("+");
            }

            if(number==N && s.empty()) break;
        }

        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
