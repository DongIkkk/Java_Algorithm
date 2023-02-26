package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Sol11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for(int i=1; i<=N; i++){
            q.add(i);
        }

        int count = 1;
        while(!q.isEmpty()){

            if(count == r){
                result.add(q.poll());
                count = 1;
            } else{
                q.add(q.poll());
                count++;
            }

        }

        System.out.print("<");
        while(!result.isEmpty()){
            System.out.printf("%d",result.poll());
            if(result.isEmpty())break;
            System.out.print(", ");
        }
        System.out.print(">");

    }
}
