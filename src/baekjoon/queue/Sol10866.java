package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                deq.addFirst(num);
            } else if(s.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                deq.addLast(num);
            } else if(s.equals("pop_front")){
                if(deq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deq.pollFirst());
                }
            } else if(s.equals("pop_back")){
                if(deq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deq.pollLast());
                }
            } else if(s.equals("size")){
                System.out.println(deq.size());
            } else if(s.equals("empty")){
                if(deq.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(s.equals("front")){
                if(deq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deq.peekFirst());
                }
            } else if(s.equals("back")){
                if(deq.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deq.peekLast());
                }
            }
        }
    }
}
